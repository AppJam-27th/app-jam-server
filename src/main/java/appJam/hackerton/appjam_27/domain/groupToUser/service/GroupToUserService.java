package appJam.hackerton.appjam_27.domain.groupToUser.service;

import appJam.hackerton.appjam_27.domain.friend.entity.FriendEntity;
import appJam.hackerton.appjam_27.domain.friend.enums.FriendState;
import appJam.hackerton.appjam_27.domain.friend.repository.FriendRepository;
import appJam.hackerton.appjam_27.domain.group.entity.GroupEntity;
import appJam.hackerton.appjam_27.domain.group.repository.GroupRepository;
import appJam.hackerton.appjam_27.domain.groupToUser.dto.req.GroupToUserReq;
import appJam.hackerton.appjam_27.domain.groupToUser.entity.GroupToUserEntity;
import appJam.hackerton.appjam_27.domain.groupToUser.repository.GroupToUserRepository;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import appJam.hackerton.appjam_27.domain.user.repository.UserRepository;
import appJam.hackerton.appjam_27.global.exception.custom.friend.NotFoundFriendException;
import appJam.hackerton.appjam_27.global.exception.custom.group.NotFoundGroupException;
import appJam.hackerton.appjam_27.global.exception.custom.user.NotFoundUserException;
import appJam.hackerton.appjam_27.global.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupToUserService {
    private final UserRepository userRepository;
    private final GroupToUserRepository groupToUserRepository;
    private final GroupRepository groupRepository;
    private final FriendRepository friendRepository;

    public Response addPeople(Long groupId, GroupToUserReq groupToUserReq) {
        GroupEntity groupEntity = groupRepository.findById(groupId)
                .orElseThrow(() -> NotFoundGroupException.EXCEPTION);

        List<GroupToUserEntity> groupToUserEntityList = new ArrayList<>();
        for (String userId : groupToUserReq.targetIdList()) {
            UserEntity userEntity = userRepository.findByUserId(groupToUserReq.userId())
                    .orElseThrow(() -> NotFoundUserException.EXCEPTION);

            UserEntity targetEntity = userRepository.findByUserId(userId)
                    .orElseThrow(() -> NotFoundUserException.EXCEPTION);

            friendRepository.findFriendsByTargetIdAndUserIdAndFriendState(targetEntity, userEntity, FriendState.ALLOW)
                    .orElseThrow(() -> NotFoundFriendException.EXCEPTION);

            GroupToUserEntity groupToUserEntity = GroupToUserEntity.builder()
                    .userId(userEntity)
                    .groupId(groupEntity)
                    .build();

            groupToUserEntityList.add(groupToUserEntity);
        }

        groupToUserRepository.saveAll(groupToUserEntityList);

        return Response.of(HttpStatus.OK, "성공");
    }

}
