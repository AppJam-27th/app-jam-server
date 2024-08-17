package appJam.hackerton.appjam_27.domain.groupToUser.entity;

import appJam.hackerton.appjam_27.domain.group.entity.GroupEntity;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tbl_group_to_user")
@DynamicUpdate
@AllArgsConstructor
public class GroupToUserEntity {
    @Id
    @Column(name = "group_to_userId")
    private Long groupToUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id")
    private UserEntity userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_group_id")
    private GroupEntity groupId;
}
