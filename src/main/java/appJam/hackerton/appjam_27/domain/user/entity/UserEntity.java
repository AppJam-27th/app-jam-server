package appJam.hackerton.appjam_27.domain.user.entity;

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
@Table(name = "tbl_user")
@DynamicUpdate
@AllArgsConstructor
public class UserEntity extends BaseTimeEntity {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_pw")
    private String userPwd;

    @Column(name = "user_rank")
    private Integer userRank;
}
