import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import appJam.hackerton.appjam_27.domain.time.service.TimeService;
import appJam.hackerton.appjam_27.global.response.ResponseData;
import lombok.RequiredArgsConstructor;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/time")
@RequiredArgsConstructor
public class TimeController {
    private final TimeService timeService;

    @GetMapping("/{time}")
    public ResponseData<Time> saveTime(@PathVariable("time") String time, @PathVariable("uid") String userId) {
        Time savedTime = timeService.saveTime(userId, time);
        // 응답으로 적절히 ResponseData를 리턴해야 합니다.
        return new ResponseData<Time>(savedTime);
    }

    @GetMapping("/setRank")
    public ResponseData<Time> setTime(@PathVariable("time") String time, @PathVariable("uid") String userId) {
        Time savedTime = timeService.saveTime(userId, time);
        // 응답으로 적절히 ResponseData를 리턴해야 합니다.
        return new ResponseData<Time>(savedTime);
    }
}
