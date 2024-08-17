package appJam.hackerton.appjam_27.domain.groupToUser.controller;

import appJam.hackerton.appjam_27.domain.groupToUser.dto.req.GroupToUserReq;
import appJam.hackerton.appjam_27.domain.groupToUser.service.GroupToUserService;
import appJam.hackerton.appjam_27.global.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groupToUser")
public class GroupToUserController {
    private final GroupToUserService groupToUserService;

    @PostMapping("/{groupId}")
    public Response addPeople(
            @PathVariable Long groupId,
            @RequestBody GroupToUserReq groupToUserReq
            ){
        return groupToUserService.addPeople(groupId, groupToUserReq);
    }
}
