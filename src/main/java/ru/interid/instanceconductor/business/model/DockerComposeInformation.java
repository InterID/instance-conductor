package ru.interid.instanceconductor.business.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class DockerComposeInformation {

    private String containerUrl;

    private String prefix;

    private String dockerComposeInstanceId;

    private short port;

}
