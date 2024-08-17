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
@Table(name = "tb_user")
@DynamicUpdate
@AllArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "member_password")
    private String memberPassword;
}
