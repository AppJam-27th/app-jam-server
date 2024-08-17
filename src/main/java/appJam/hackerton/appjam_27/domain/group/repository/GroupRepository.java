package appJam.hackerton.appjam_27.domain.group.repository;

import appJam.hackerton.appjam_27.domain.group.entity.GroupEntity;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
    List<GroupEntity> findByGroupName(String group);
}