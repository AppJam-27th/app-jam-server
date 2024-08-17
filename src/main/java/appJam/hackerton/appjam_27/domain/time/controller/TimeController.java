package appJam.hackerton.appjam_27.domain.time.controller;

import appJam.hackerton.appjam_27.domain.time.dto.req.TimeReq;
import appJam.hackerton.appjam_27.domain.time.service.TimeService;
import appJam.hackerton.appjam_27.global.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
