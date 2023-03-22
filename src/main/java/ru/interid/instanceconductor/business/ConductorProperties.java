package ru.interid.instanceconductor.business;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "conductor")
public class ConductorProperties {

    private String protocol;
    private String mainDomain;
    private int emptyContainerCount;

}
