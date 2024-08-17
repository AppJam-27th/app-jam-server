package appJam.hackerton.appjam_27.global.exception.custom.group;

import appJam.hackerton.appjam_27.global.exception.BusinessException;
import appJam.hackerton.appjam_27.global.exception.StatusEnum;

public class NotFoundGroupException extends BusinessException {
    public static final BusinessException EXCEPTION = new NotFoundGroupException();

    public NotFoundGroupException() {
        super(StatusEnum.NOT_FOUND_GROUP);
    }
}