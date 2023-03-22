package ru.interid.instanceconductor.business.dockerComposeManager;

public interface NginxHelper {

    void configureNginx(String prefix, short port);

}
