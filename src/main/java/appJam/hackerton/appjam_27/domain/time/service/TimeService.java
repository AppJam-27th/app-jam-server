package appJam.hackerton.appjam_27.domain.time.service;

import java.sql.Time;

import appJam.hackerton.appjam_27.domain.time.dto.req.TimeReq;
import appJam.hackerton.appjam_27.domain.time.entity.TimeEntity;
import appJam.hackerton.appjam_27.domain.time.repository.TimeRepository;
import appJam.hackerton.appjam_27.global.exception.custom.user.NotFoundUserException;
import appJam.hackerton.appjam_27.global.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import appJam.hackerton.appjam_27.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TimeService {

    private final TimeRepository timeRepository;
    private final UserRepository userRepository;

    public Response saveTime(TimeReq timeReq) {
        UserEntity user = userRepository.findByUserId(timeReq.userId())
                .orElseThrow(NotFoundUserException::new);

        TimeEntity timeEntity = TimeEntity.builder()
                .userId(user)
                .userTime(timeReq.time())
                .build();

        timeRepository.save(timeEntity);

        return Response.of(HttpStatus.OK, "성공");
    }

}
