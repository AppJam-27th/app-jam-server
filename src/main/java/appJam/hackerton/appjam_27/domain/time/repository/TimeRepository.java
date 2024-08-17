import java.sql.Time;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends TimeEntity<Time, Long> {
    
}
