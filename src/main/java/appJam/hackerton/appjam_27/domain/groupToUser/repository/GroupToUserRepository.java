package appJam.hackerton.appjam_27.domain.groupToUser.repository;

import appJam.hackerton.appjam_27.domain.group.entity.GroupEntity;
import appJam.hackerton.appjam_27.domain.groupToUser.entity.GroupToUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupToUserRepository extends JpaRepository<GroupToUserEntity, Long> {
}
