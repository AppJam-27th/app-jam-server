package appJam.hackerton.appjam_27.global.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusEnum {
    NOT_FOUND_USER(404, "유저를 찾을 수 없습니다."),
    ALREADY_EXIST_USER(403, "이미 존재하는 유저입니다."),
    NOT_FOUND_FRIEND(403, "친구요청이 없습니다.");


    private final int statusCode;
    private final String message;
}
