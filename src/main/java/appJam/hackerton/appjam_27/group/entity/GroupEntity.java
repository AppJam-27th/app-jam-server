package appJam.hackerton.appjam_27.domain.group.entity;

import appJam.hackerton.appjam_27.global.common.entity.BaseTimeEntity;
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
@Table(name = "tbl_group")
@DynamicUpdate
@AllArgsConstructor
public class GroupEntity extends BaseTimeEntity {
    @Id
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_name")
    private String groupName;
}