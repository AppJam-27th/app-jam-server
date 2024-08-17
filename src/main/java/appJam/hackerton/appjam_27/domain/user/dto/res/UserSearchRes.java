package appJam.hackerton.appjam_27.domain.user.dto.res;

import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;

public record UserSearchRes(
        String userId,
        String userName,
        Integer userRank
) {
    public static UserSearchRes of(UserEntity userEntity) {
        return new UserSearchRes(userEntity.getUserId(), userEntity.getUserName(), userEntity.getUserRank());
    }
}
