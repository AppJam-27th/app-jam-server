package appJam.hackerton.appjam_27.domain.time.repository;

import appJam.hackerton.appjam_27.domain.time.entity.TimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<TimeEntity, Long> {
    
}


