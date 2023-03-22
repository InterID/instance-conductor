package ru.interid.instanceconductor.business.dockerComposeManager;

public interface DockerComposeCreator {

    void createDockerCompose(String prefix, short port);

}
