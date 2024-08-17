package appJam.hackerton.appjam_27.domain.user.repository;

import java.util.List;
import java.util.Optional;

import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserId(String userId);

    boolean existsUserEntityByUserId(String userId);

    List<UserEntity> findAllByOrderByUserIdDesc();
    Long timeCount = timeRepository.countByStatusAndAnotherField(status, anotherValue);

    // 유저별 (총 시간 / userTime 칼럼의 갯수 ==> 평균 사용시간)에 따른 내림차순 정렬
    @Query("SELECT u FROM UserEntity u " +
            "LEFT JOIN TimeEntity t ON u.userId = t.userId " +
            "GROUP BY u.userId " +
            "ORDER BY SUM(t.userTime) / :time DESC")
    List<UserEntity> findAllOrderByCalculatedTimeDesc();


    //    // rank 필드를 기준으로 내림차순 정렬된 사용자 목록을 가져오는 쿼리
//    @Query("SELECT uid FROM UserEntity uid ORDER BY uid.rank DESC")
//    List<UserEntity> findAllOrderByRankDesc(@Param("uid") String uid);
//
//    // 사용자의 랭크를 지정하는 쿼리
//    @Query("SELECT uid FROM UserEntity uid ORDER BY uid.rank DESC")
//    List<UserEntity> findAllOrderByRankDesc(@Param("uid") String uid);
//
//    // // 사용자 목록을 가져오는 쿼리
//    @Query("SELECT :userId FROM :tbl_user")
//    List<UserEntity> userId();
    
    // 특정 userId로 사용자 조회
   // @Query("SELECT u FROM UserEntity u WHERE u.id = :userId")
    UserEntity findById(@Param("userId") Long userId);
}