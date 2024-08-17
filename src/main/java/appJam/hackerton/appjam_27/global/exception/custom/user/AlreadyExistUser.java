package appJam.hackerton.appjam_27.global.exception.custom.user;

import appJam.hackerton.appjam_27.global.exception.BusinessException;
import appJam.hackerton.appjam_27.global.exception.StatusEnum;

public class AlreadyExistUser extends BusinessException {
    public static final BusinessException EXCEPTION = new AlreadyExistUser();

    public AlreadyExistUser() {
        super(StatusEnum.ALREADY_EXIST_USER);
    }
}
