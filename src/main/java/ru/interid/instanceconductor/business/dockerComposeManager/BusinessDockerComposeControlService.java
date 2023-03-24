package ru.interid.instanceconductor.business.dockerComposeManager;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.interid.instanceconductor.business.DockerComposeControlService;
import ru.interid.instanceconductor.business.model.DockerComposeInformation;

import java.util.Random;


@Service
@RequiredArgsConstructor
public class BusinessDockerComposeControlService implements DockerComposeControlService {

    private final DnsCreator dnsCreator;
    private final DockerComposeCreator dockerComposeCreator;
    private final NginxHelper nginxHelper;

    @Override
    public DockerComposeInformation createNewInstance(@NonNull String prefix) {
        short port = (short) (new Random().nextInt(8000) + 1050);
        dnsCreator.createDns(prefix);
        dockerComposeCreator.createDockerCompose(prefix, port);
        nginxHelper.configureNginx(prefix, port);

        DockerComposeInformation dockerComposeInformation = new DockerComposeInformation();
        dockerComposeInformation.setPrefix(prefix);
        dockerComposeInformation.setContainerUrl("localhost");//todo
        dockerComposeInformation.setPort(port);
        dockerComposeInformation.setDockerComposeInstanceId("not implemented");//todo

        return dockerComposeInformation;
    }

    @SneakyThrows
    @Override
    public void clearInstance(DockerComposeInformation dockerComposeInformation) {
        //todo
        throw new Exception();
    }
}
