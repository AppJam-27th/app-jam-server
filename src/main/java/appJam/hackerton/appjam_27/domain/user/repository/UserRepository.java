package appJam.hackerton.appjam_27.domain.user.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public class UserRepository {
}


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    // rank 필드를 기준으로 내림차순 정렬된 사용자 목록을 가져오는 쿼리
    @Query("SELECT uid FROM UserEntity uid ORDER BY uid.rank DESC")
    List<UserEntity> findAllOrderByRankDesc(@Param("uid") Long uid);

    // 사용자의 랭크를 지정하는 쿼리
    @Query("SELECT uid FROM UserEntity uid ORDER BY uid.rank DESC")
    List<UserEntity> findAllOrderByRankDesc(@Param("uid") Long uid);

    // // 사용자 목록을 가져오는 쿼리
    @Query("SELECT :userId FROM :tbl_user")
    List<UserEntity> userId();
    
    // 특정 userId로 사용자 조회
    @Query("SELECT u FROM UserEntity u WHERE u.id = :userId")
    UserEntity findById(@Param("userId") Long userId);
}