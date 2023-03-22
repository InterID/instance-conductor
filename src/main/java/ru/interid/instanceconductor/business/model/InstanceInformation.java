package ru.interid.instanceconductor.business.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class InstanceInformation {

    private String url;

    private LocalDateTime dateCreated;

    private String userLogin;

    public InstanceInformation(UnionInstance unionInstance, String protocol, String mainDomain) {
        this.dateCreated = unionInstance.getDateCreated();
        this.userLogin = unionInstance.getUserLogin().orElse(null);
        this.url = protocol + unionInstance.getDockerComposeInformation().getPrefix() + "." + mainDomain;
    }

}
