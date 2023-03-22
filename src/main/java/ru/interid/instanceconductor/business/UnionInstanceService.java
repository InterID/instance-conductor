package ru.interid.instanceconductor.business;

import lombok.NonNull;
import ru.interid.instanceconductor.business.model.InstanceInformation;

import java.util.List;

public interface UnionInstanceService {

    InstanceInformation registry(@NonNull String userLogin);

    List<InstanceInformation> getRegisteredInstances(@NonNull String userLogin);

    void createMissingInstances();

}
