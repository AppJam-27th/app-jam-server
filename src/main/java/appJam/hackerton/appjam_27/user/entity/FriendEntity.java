package appJam.hackerton.appjam_27.user.entity;

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
@Table(name = "tb_friend")
@DynamicUpdate
@AllArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "friend_state")
    private String friendState;

    @Column(name = "user_id2")
    private String userId2;
}
