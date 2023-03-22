package ru.interid.instanceconductor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class InstanceConductorApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstanceConductorApplication.class, args);
    }

}
