package appJam.hackerton.appjam_27.domain.user.controller;

import appJam.hackerton.appjam_27.domain.user.dto.req.UserReq;
import appJam.hackerton.appjam_27.domain.user.dto.res.UserRes;
import appJam.hackerton.appjam_27.domain.user.service.UserService;
import appJam.hackerton.appjam_27.global.response.Response;
import appJam.hackerton.appjam_27.global.response.ResponseData;
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
            @RequestBody UserReq userReq){
        return userService.request(userReq);
    }
  
    @GetMapping("/{userId}")
    public ResponseData<UserRes> read(
            @PathVariable String userId){
        return userService.read(userId);
    }

    @GetMapping("/{userId}")
    public ResponseData<UserRes> read(
            @PathVariable String userId){
        return userService.read(userId);
    }

}
