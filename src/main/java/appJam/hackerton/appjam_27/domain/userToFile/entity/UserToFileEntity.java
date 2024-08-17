package appJam.hackerton.appjam_27.domain.userToFile.entity;

import appJam.hackerton.appjam_27.domain.file.entity.FileEntity;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import appJam.hackerton.appjam_27.global.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@Entity(name = "tbl_user_file")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserToFileEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userToFileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id", nullable = false)
    private UserEntity userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_file_id", nullable = false)
    private FileEntity fileId;

}
