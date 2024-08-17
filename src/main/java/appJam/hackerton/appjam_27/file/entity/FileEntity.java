
package appJam.hackerton.appjam_27.file.entity;

import appJam.hackerton.appjam_27.userToFile.entity.UserToFileEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tbl_file")
@DynamicUpdate
@AllArgsConstructor
public class FileEntity {
    @Id
    @Column(name = "file_id")
    private String fileId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_size")
    private String fileSize;

    @OneToMany(mappedBy = "fileId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserToFileEntity> userToFileEntityList;
}

