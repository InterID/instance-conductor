package ru.interid.instanceconductor.business;

import lombok.NonNull;
import ru.interid.instanceconductor.business.model.DockerComposeInformation;

public interface DockerComposeControlService {

    DockerComposeInformation createNewInstance(String prefix);

    void clearInstance(@NonNull DockerComposeInformation dockerComposeInformation);

}
