package appJam.hackerton.appjam_27.domain.time.service;

import java.sql.Time;

import org.springframework.stereotype.Service;

import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import appJam.hackerton.appjam_27.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TimeService {

    private final TimeRepository timeRepository;
    private final UserRepository userRepository;

    public Time saveTime(Long userId, Integer userTime) {
        UserEntity user = userRepository.findById(userId);

        Time time = new Time(user, userTime);
        return timeRepository.save(time);
    }

}
