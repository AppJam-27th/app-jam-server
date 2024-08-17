package appJam.hackerton.appjam_27.domain.friend.cotroller;

import appJam.hackerton.appjam_27.domain.friend.dto.req.FriendReq;
import appJam.hackerton.appjam_27.domain.friend.service.FriendService;
import appJam.hackerton.appjam_27.global.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
