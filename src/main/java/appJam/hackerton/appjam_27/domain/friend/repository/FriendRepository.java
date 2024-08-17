package appJam.hackerton.appjam_27.domain.friend.repository;

import appJam.hackerton.appjam_27.domain.friend.entity.FriendEntity;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, Long> {
    List<FriendEntity> findAllByUserEntity2(UserEntity targetEntity);
}
