package ru.interid.instanceconductor.output;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.interid.instanceconductor.business.UnionInstanceDataProvider;
import ru.interid.instanceconductor.business.model.UnionInstance;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SQLUnionInstanceDataProvider implements UnionInstanceDataProvider {

    private final UnionInstanceRepository unionInstanceRepository;

    @Override
    public UnionInstance save(UnionInstance unionInstance) {
        return unionInstanceRepository.save(unionInstance);
    }

    @Override
    public Optional<UnionInstance> findFirstWithoutUser() {
        return unionInstanceRepository.findFirstByUserLoginIsNull();
    }

    @Override
    public List<UnionInstance> findByUserLogin(@NonNull String login) {
        return unionInstanceRepository.findAllByUserLogin(login);

    }

    @Override
    public long countOfWithoutUser() {
        return unionInstanceRepository.countByUserLoginIsNull();
    }
}
