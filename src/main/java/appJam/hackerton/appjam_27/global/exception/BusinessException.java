package appJam.hackerton.appjam_27.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private final StatusEnum errorCode;
}
