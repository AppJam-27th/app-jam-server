package appJam.hackerton.appjam_27.domain.time.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Dictionary;
import java.util.List;

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

    public Time saveTime(Long userId, Integer userTime) {
        UserEntity user = userRepository.findById(userId);

        Time time = new Time(user, userTime);
        return timeRepository.save(time);
    }

    // #endregions

    // #region 랭크 내림차순에 따른 유저 랭크정의

    public UserEntity setTime(Integer userTime) {

        // 금일 날짜 일요일? 확인
        if(LocalDate.now().getDayOfWeek() == "SUNDAY")
        {
            List<UserEntity> users = userRepository.userId();
            List<UserEntity> ranking = userRepository.findAllOrderByRankDesc(userTime);

            foreach(Long i : users) ranking(i);
            return ranking;
        }
        else return 0;

    }

    // #endregion
}
