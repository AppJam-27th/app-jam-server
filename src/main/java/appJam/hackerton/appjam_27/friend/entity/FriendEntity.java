package appJam.hackerton.appjam_27.friend.entity;

import appJam.hackerton.appjam_27.user.entity.UserEntity;
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
public class FriendEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id")
    private UserEntity userEntity;

    @Column(name = "friend_state")
    private String friendState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id2")
    private UserEntity userEntity2;
}
