package appJam.hackerton.appjam_27.global.exception.custom.friend;

import appJam.hackerton.appjam_27.global.exception.BusinessException;
import appJam.hackerton.appjam_27.global.exception.StatusEnum;

public class NotFoundFriendException extends BusinessException {
    public static final BusinessException EXCEPTION = new NotFoundFriendException();

    public NotFoundFriendException() {
        super(StatusEnum.NOT_FOUND_FRIEND);
    }
}