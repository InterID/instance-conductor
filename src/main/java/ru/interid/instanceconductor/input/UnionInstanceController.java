package ru.interid.instanceconductor.input;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import ru.interid.instanceconductor.business.UnionInstanceService;
import ru.interid.instanceconductor.business.model.InstanceInformation;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class UnionInstanceController {

    private final UnionInstanceService unionInstanceService;

    @PostMapping("/register")
    private ResponseEntity<InstanceInformation> registerUnionInstance(@RequestBody UserInformationDto userInformationDto) {
        String login = userInformationDto.getLogin();
        if(ObjectUtils.isEmpty(login))
            return null;//todo

        InstanceInformation instanceInformation = unionInstanceService.registry(login);

        return ResponseEntity.ok(instanceInformation);
    }

    @GetMapping("/users/{userLogin}/union-instances")
    private ResponseEntity<List<InstanceInformation>> getRegisteredInstances(@NonNull @PathVariable String userLogin) {
        return ResponseEntity.ok(unionInstanceService.getRegisteredInstances(userLogin));
    }

}
