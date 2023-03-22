package ru.interid.instanceconductor.business;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.interid.instanceconductor.business.model.DockerComposeInformation;
import ru.interid.instanceconductor.business.model.InstanceInformation;
import ru.interid.instanceconductor.business.model.UnionInstance;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BusinessUnionInstanceService implements UnionInstanceService {

    private final ConductorProperties conductorProperties;
    private final UnionInstanceDataProvider unionInstanceDataProvider;
    private final DockerComposeControlService dockerComposeControlService;
    private final PrefixGenerator prefixGenerator;

    @SneakyThrows
    @Override
    public InstanceInformation registry(@NonNull String userLogin) {
        Optional<UnionInstance> unionInstanceOptional = unionInstanceDataProvider.findFirstWithoutUser();
        if (unionInstanceOptional.isEmpty()) {
            //todo выкидываем ошибку
            throw new Exception();
        } else {
            UnionInstance unionInstance = unionInstanceOptional.get();
            unionInstance.setUserLogin(userLogin);
            unionInstance = unionInstanceDataProvider.save(unionInstance);
            return createInstanceInformation(unionInstance);
        }
    }


    @Override
    public List<InstanceInformation> getRegisteredInstances(@NonNull String userLogin) {
        return unionInstanceDataProvider.findByUserLogin(userLogin).stream().
                map(this::createInstanceInformation).
                collect(Collectors.toList());
    }

    @Override
    public void createMissingInstances() {
        if(unionInstanceDataProvider.countOfWithoutUser() < conductorProperties.getEmptyContainerCount())
            createEmptyInstance();
    }

    private void createEmptyInstance() {
        DockerComposeInformation dockerComposeInformation = dockerComposeControlService.createNewInstance(prefixGenerator.generateFreePrefix());
        UnionInstance unionInstance = new UnionInstance();
        unionInstance.setDockerComposeInformation(dockerComposeInformation);
        unionInstance.setDateCreated(LocalDateTime.now());
        unionInstanceDataProvider.save(unionInstance);
    }

    private InstanceInformation createInstanceInformation(@NonNull UnionInstance unionInstance) {
        return new InstanceInformation(unionInstance, conductorProperties.getProtocol(), conductorProperties.getMainDomain());
    }

}
