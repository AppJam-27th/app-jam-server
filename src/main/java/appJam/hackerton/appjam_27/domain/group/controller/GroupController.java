package appJam.hackerton.appjam_27.domain.group.controller;

import appJam.hackerton.appjam_27.domain.group.service.GroupService;
import appJam.hackerton.appjam_27.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;

    @PostMapping
    public ResponseData<Long> generate(
            @RequestBody String groupName
    ){
        return groupService.generate(groupName);
    }

}
