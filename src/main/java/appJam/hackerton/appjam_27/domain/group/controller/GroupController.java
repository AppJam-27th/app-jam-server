package appJam.hackerton.appjam_27.domain.group.controller;

import appJam.hackerton.appjam_27.domain.group.service.GroupService;
import appJam.hackerton.appjam_27.domain.time.service.TimeService;
import appJam.hackerton.appjam_27.domain.group.entity.GroupEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/{groupname}")
    public List<GroupEntity> search(@PathVariable() String groupname) {
        return groupService.search(groupname);
    }

}