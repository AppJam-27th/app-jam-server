package appJam.hackerton.appjam_27.domain.user.repository;

import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserId(String userId);
    boolean existsUserEntityByUserId(String userId);

    // 유저별 (총 시간 / userTime 칼럼의 갯수 ==> 평균 사용시간)에 따른 내림차순 정렬
    @Query("SELECT u FROM UserEntity u " +
            "LEFT JOIN TimeEntity t ON u.userId = t.userId " +
            "GROUP BY u.userId " +
            "ORDER BY SUM(t.userTime) / COUNT(t) DESC")
    List<UserEntity> findAllOrderByCalculatedTimeDesc();

}