package appJam.hackerton.appjam_27.global.exception.custom.user;

import appJam.hackerton.appjam_27.global.exception.BusinessException;
import appJam.hackerton.appjam_27.global.exception.StatusEnum;

public class NotFoundUserException extends BusinessException {
    public static final BusinessException EXCEPTION = new NotFoundUserException();

    public NotFoundUserException() {
        super(StatusEnum.NOT_FOUND_USER);
    }
}
