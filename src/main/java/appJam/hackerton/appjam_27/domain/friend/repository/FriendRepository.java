package appJam.hackerton.appjam_27.domain.friend.repository;

import appJam.hackerton.appjam_27.domain.friend.entity.FriendEntity;
import appJam.hackerton.appjam_27.domain.friend.enums.FriendState;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, Long> {

    @Query("SELECT f FROM FriendEntity f WHERE f.userEntity2 = :userId2 AND f.userEntity = :userId")
    Optional<FriendEntity> findFriendsByTargetIdAndUserId(@Param("userId2") UserEntity targetId, @Param("userId") UserEntity userId);


    @Query("SELECT f FROM FriendEntity f WHERE f.userEntity2 = :userId2 AND f.userEntity = :userId AND f.friendState = :friendState")
    Optional<FriendEntity> findFriendsByTargetIdAndUserIdAndFriendState(@Param("userId2") UserEntity targetId, @Param("userId") UserEntity userId, FriendState friendState);

    Optional<FriendEntity> findByUserEntity2(UserEntity userEntity);
    List<FriendEntity> findAllByUserEntity2(UserEntity targetEntity);
}
