package appJam.hackerton.appjam_27.domain.friend.dto.res;

import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;

public record FriendRes(
        String userId,
        String userName,
        Integer userRank,
//        Long userTime

) {
    public static FriendRes of(UserEntity userEntity) {
        return new FriendRes(userEntity.getUserId(), userEntity.getUserName(), userEntity.getUserRank());
    }
}
