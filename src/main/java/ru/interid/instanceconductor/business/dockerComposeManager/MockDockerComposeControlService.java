package ru.interid.instanceconductor.business.dockerComposeManager;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.interid.instanceconductor.business.DockerComposeControlService;
import ru.interid.instanceconductor.business.model.DockerComposeInformation;

import java.util.ArrayList;
import java.util.Random;

//@Service
public class MockDockerComposeControlService implements DockerComposeControlService {

    private ArrayList<DockerComposeInformation> dockerComposeInformations = new ArrayList<>();

    @Override
    public DockerComposeInformation createNewInstance(@NonNull String prefix) {
        DockerComposeInformation dockerComposeInformation = new DockerComposeInformation();
        dockerComposeInformation.setDockerComposeInstanceId("" + new Random().nextInt(5000));
        dockerComposeInformation.setPort(Short.parseShort("" +new Random().nextInt(9999)));
        dockerComposeInformation.setContainerUrl("localhost");
        dockerComposeInformation.setPrefix(prefix);
        dockerComposeInformations.add(dockerComposeInformation);
        return dockerComposeInformation;
    }

    @Override
    public void clearInstance(DockerComposeInformation dockerComposeInformation) {
        for(DockerComposeInformation dockerComposeInformation1: dockerComposeInformations) {
            if(dockerComposeInformation1.getPrefix().equals(dockerComposeInformation.getPrefix())){
                dockerComposeInformations.remove(dockerComposeInformation1);
                break;
            }
        }
    }
}

