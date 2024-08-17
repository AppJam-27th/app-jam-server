package appJam.hackerton.appjam_27.domain.time.controller;

import appJam.hackerton.appjam_27.domain.time.dto.req.TimeReq;
import appJam.hackerton.appjam_27.domain.time.service.TimeService;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import appJam.hackerton.appjam_27.global.response.Response;
import appJam.hackerton.appjam_27.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time")
@RequiredArgsConstructor
public class TimeController {

    private final TimeService timeService;

    @PostMapping()
    public Response saveTime(
            @RequestBody TimeReq timeReq
            ) {
        return timeService.saveTime(timeReq);
    }

    @GetMapping
    public ResponseData<List<UserEntity>> setTime(){
        return timeService.setTime();
    }
