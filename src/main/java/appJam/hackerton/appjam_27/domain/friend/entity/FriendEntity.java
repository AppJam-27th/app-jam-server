package appJam.hackerton.appjam_27.domain.friend.entity;

import appJam.hackerton.appjam_27.domain.friend.enums.FriendState;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
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
@Table(name = "tbl_friend")
@DynamicUpdate
@AllArgsConstructor
public class FriendEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long FriendId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id")
    private UserEntity userEntity;

    @Column(name = "friend_state")
    @Enumerated(EnumType.STRING)
    private FriendState friendState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id2")
    private UserEntity userEntity2;
}
