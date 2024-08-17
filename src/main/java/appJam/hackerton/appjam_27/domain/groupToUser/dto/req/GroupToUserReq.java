package appJam.hackerton.appjam_27.domain.groupToUser.dto.req;

import java.util.List;

public record GroupToUserReq(
        String userId,
        List<String> targetIdList
) {
}
