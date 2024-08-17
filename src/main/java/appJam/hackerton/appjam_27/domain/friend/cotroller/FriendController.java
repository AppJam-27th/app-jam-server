package appJam.hackerton.appjam_27.domain.friend.cotroller;

import appJam.hackerton.appjam_27.domain.friend.dto.req.FriendReq;
import appJam.hackerton.appjam_27.domain.friend.dto.res.FriendRes;
import appJam.hackerton.appjam_27.domain.friend.service.FriendService;
import appJam.hackerton.appjam_27.global.response.Response;
import appJam.hackerton.appjam_27.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

    @PostMapping
    public Response request(
            @RequestBody FriendReq friendReq){
        return friendService.request(friendReq);
    }

    @GetMapping("/{targetId}")
    public ResponseData<List<FriendRes>> findMy(
            @PathVariable String targetId
    ){
        return friendService.findMy(targetId);
    }

    @PatchMapping("/{targetId}/{userId}")
    public Response allow(
            @PathVariable String targetId,
            @PathVariable String userId
    ){
        return friendService.allow(targetId, userId);
    }

    @PatchMapping("/detected/{targetId}/{userId}")
    public Response detected(
            @PathVariable String targetId,
            @PathVariable String userId
    ){
        return friendService.detected(targetId, userId);
    }
}
