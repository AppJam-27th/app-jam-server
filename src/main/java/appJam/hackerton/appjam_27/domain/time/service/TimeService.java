package appJam.hackerton.appjam_27.domain.time.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Dictionary;
import java.util.List;

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
import main.java.appJam.hackerton.appjam_27.domain.time.repository.TimeRepository;

@Service
@RequiredArgsConstructor
public class TimeService {

    // #region 시간기록 테이블에 insert
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

    // #endregions



    // #region 평균 사용시간에 따른 유저 순위 정렬
    public List<UserEntity> setTime() {
        List<UserEntity> userRanking = userRepository.findAllOrderByCalculatedTimeDesc();
        return userRanking;
    }
    // #endregion
}
