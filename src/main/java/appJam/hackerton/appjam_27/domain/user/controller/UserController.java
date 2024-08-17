package appJam.hackerton.appjam_27.domain.user.controller;

import appJam.hackerton.appjam_27.domain.user.dto.req.UserReq;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import appJam.hackerton.appjam_27.domain.user.service.UserService;
import appJam.hackerton.appjam_27.global.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public Response request(
            @RequestBody UserReq userReq) {

        return userService.request(userReq);
    }

    @GetMapping("/{username}")
    public List<UserEntity> search(@PathVariable() String username) {
        return userService.search(username);
    }

}
