package appJam.hackerton.appjam_27.domain.group.repository;

import appJam.hackerton.appjam_27.domain.group.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
}
