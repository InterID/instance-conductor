package ru.interid.instanceconductor.business;

import lombok.NonNull;
import ru.interid.instanceconductor.business.model.UnionInstance;

import java.util.List;
import java.util.Optional;


public interface UnionInstanceDataProvider {

    UnionInstance save(@NonNull UnionInstance unionInstance);

    Optional<UnionInstance> findFirstWithoutUser();

    List<UnionInstance> findByUserLogin(@NonNull String login);

    long countOfWithoutUser();

}
