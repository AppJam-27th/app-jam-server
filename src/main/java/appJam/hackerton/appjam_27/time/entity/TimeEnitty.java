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
<<<<<<< HEAD
    private Long userTime;
=======
    private Integer userTime;
>>>>>>> 31054b9204b2d7a98ef1f347d863fdbef99e3810

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id")
    private UserEntity userId;
}
