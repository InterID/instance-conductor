package ru.interid.instanceconductor.input;


import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.interid.instanceconductor.business.UnionInstanceService;

@Service
@RequiredArgsConstructor
public class InstanceCheckScheduler {

    private final UnionInstanceService unionInstanceService;

    @Timed("actualInstancesScheduler")
    @Scheduled(fixedDelay = 60_000)
    void actualInstances() {
        unionInstanceService.createMissingInstances();
    }

    //todo метод на удаление из бд сущностей, для которых нет
}
