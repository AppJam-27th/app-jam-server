package appJam.hackerton.appjam_27.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdAndUserPwd(Long id, String pwd);
}