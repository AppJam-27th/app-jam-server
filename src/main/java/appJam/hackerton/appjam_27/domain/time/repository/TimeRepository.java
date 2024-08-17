package appJam.hackerton.appjam_27.domain.time.repository;

import appJam.hackerton.appjam_27.domain.time.entity.TimeEntity;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeRepository extends JpaRepository<TimeEntity, Long> {
    List<TimeEntity> findAllTimeEntityByUserId(UserEntity userEntity);
}
