package ru.interid.instanceconductor.business.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Entity
public class UnionInstance {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private LocalDateTime dateCreated;

    @Embedded
    private DockerComposeInformation dockerComposeInformation;

    @Column
    private String userLogin;


    public Optional<String> getUserLogin() {
        return Optional.of(userLogin);
    }

    public UnionInstance() {

    }



}
