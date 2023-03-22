package ru.interid.instanceconductor.output;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.interid.instanceconductor.business.model.UnionInstance;

import java.util.List;
import java.util.Optional;

public interface UnionInstanceRepository extends JpaRepository<UnionInstance, Long> {

    @Override
    <S extends UnionInstance> S save(S entity);

    <S extends UnionInstance> Optional<S> findFirstByUserLoginIsNull();

    List<UnionInstance> findAllByUserLogin(String userLogin);

    long countByUserLoginIsNull();
}
