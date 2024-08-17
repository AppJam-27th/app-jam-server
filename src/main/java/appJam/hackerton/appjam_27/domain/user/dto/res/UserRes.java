package appJam.hackerton.appjam_27.domain.user.dto.res;

import appJam.hackerton.appjam_27.domain.time.dto.res.TimeRes;
import appJam.hackerton.appjam_27.domain.time.entity.TimeEntity;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public record UserRes(
        String userId,
        String userName,
        Integer userRank,
        List<TimeRes> timeResList

) {
    public static UserRes of(UserEntity userEntity, List<TimeEntity> timeEntityList) {
        List<TimeRes> timeRes = new ArrayList<>();
        for(TimeEntity time : timeEntityList){
            timeRes.add(TimeRes.of(time));
        }
        return new UserRes(
                userEntity.getUserId(),
                userEntity.getUserName(),
                userEntity.getUserRank(),
                timeRes);
    }
}
