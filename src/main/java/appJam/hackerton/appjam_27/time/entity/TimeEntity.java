package appJam.hackerton.appjam_27.time.entity;

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
@Table(name = "tbl_time")
@DynamicUpdate
@AllArgsConstructor
public class TimeEntity {
    @Id
    @Column(name = "time_id")
    private Long timeId;

    @Column(name = "user_time")
    private Integer userTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id")
    private UserEntity userId;
}
