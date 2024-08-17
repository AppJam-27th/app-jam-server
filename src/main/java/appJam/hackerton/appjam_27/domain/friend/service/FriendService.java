package appJam.hackerton.appjam_27.domain.friend.service;

import appJam.hackerton.appjam_27.domain.friend.dto.req.FriendReq;
import appJam.hackerton.appjam_27.domain.friend.dto.res.FriendRes;
import appJam.hackerton.appjam_27.domain.friend.entity.FriendEntity;
import appJam.hackerton.appjam_27.domain.friend.enums.FriendState;
import appJam.hackerton.appjam_27.domain.friend.repository.FriendRepository;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import appJam.hackerton.appjam_27.domain.user.repository.UserRepository;
import appJam.hackerton.appjam_27.global.exception.custom.user.NotFoundUserException;
import appJam.hackerton.appjam_27.global.response.Response;
import appJam.hackerton.appjam_27.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;

    public Response request(FriendReq friendReq){
        UserEntity userEntity = userRepository.findByUserId(friendReq.getUserId())
                .orElseThrow(NotFoundUserException::new);

        UserEntity targetUserEntity = userRepository.findByUserId(friendReq.getTargetId())
                .orElseThrow(NotFoundUserException::new);

        FriendEntity friendEntity = FriendEntity.builder()
                .userEntity(userEntity)
                .friendState(FriendState.PENDING)
                .userEntity2(targetUserEntity)
                .build();
        friendRepository.save(friendEntity);

        return Response.of(HttpStatus.OK, "성공");
    }

    public ResponseData<List<FriendRes>> findMy(String targetId){
        UserEntity userEntity = userRepository.findByUserId(targetId)
                .orElseThrow(NotFoundUserException::new);

        List<FriendEntity> friendEntityList = friendRepository.findAllByUserEntity2(userEntity);

        List<UserEntity> userEntityList = new ArrayList<>();
        for(FriendEntity friendEntity:friendEntityList){
            userEntityList.add(userRepository.findByUserId(friendEntity.getUserEntity().getUserId())
                    .orElseThrow(NotFoundUserException::new));
        }
//        FriendRes.of(userEntity.getUserId());

        return null;
    }

}
