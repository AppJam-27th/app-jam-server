package appJam.hackerton.appjam_27.userToFile.entity;

import appJam.hackerton.appjam_27.file.entity.FileEntity;
import appJam.hackerton.appjam_27.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@Entity(name = "tbl_user_file")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserToFileEntity {

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
