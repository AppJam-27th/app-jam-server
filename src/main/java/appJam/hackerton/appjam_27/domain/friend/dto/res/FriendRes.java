package appJam.hackerton.appjam_27.domain.friend.dto.res;

public record FriendRes(
        String userId

) {
    public static FriendRes of(String userId){
        return new FriendRes(userId);
    }
}
