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
@Table(name = "tb_time")
@DynamicUpdate
@AllArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "time_id")
    private String timeId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_time")
    private String userTime;
}
