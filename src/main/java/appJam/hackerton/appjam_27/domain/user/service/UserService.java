package appJam.hackerton.appjam_27.domain.user.service;

import appJam.hackerton.appjam_27.domain.time.entity.TimeEntity;
import appJam.hackerton.appjam_27.domain.time.repository.TimeRepository;
import appJam.hackerton.appjam_27.domain.user.dto.req.UserReq;
import appJam.hackerton.appjam_27.domain.user.dto.res.UserRes;
import appJam.hackerton.appjam_27.domain.user.dto.res.UserSearchRes;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import appJam.hackerton.appjam_27.domain.user.repository.UserRepository;
import appJam.hackerton.appjam_27.global.exception.custom.user.AlreadyExistUser;
import appJam.hackerton.appjam_27.global.exception.custom.user.NotFoundUserException;
import appJam.hackerton.appjam_27.global.response.Response;
import appJam.hackerton.appjam_27.global.response.ResponseData;
import lombok.RequiredArgsConstructor;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TimeRepository timeRepository;

    public Response request(UserReq userReq){

        if(userReq.userId()==null){
            throw NotFoundUserException.EXCEPTION;
        }

        if (userRepository.existsUserEntityByUserId(userReq.userId())){
            throw AlreadyExistUser.EXCEPTION;
        };

        UserEntity userEntity = UserEntity.builder()
                .userId(userReq.userId())
                .userName(userReq.userName())
                .userPwd(userReq.userPwd())
                .build();

        userRepository.save(userEntity);
        return Response.of(HttpStatus.OK, "성공");
    }
      
    public ResponseData<UserRes> read(String userId){
        UserEntity userEntity = userRepository.findByUserId(userId)
                .orElseThrow(() -> NotFoundUserException.EXCEPTION);

        List<TimeEntity> timeEntity = timeRepository.findAllTimeEntityByUserId(userEntity);

        return ResponseData.of(HttpStatus.OK, "성공", UserRes.of(userEntity, timeEntity));
    }

    public ResponseData<List<UserSearchRes>> search(String userName) {
        List<UserEntity> result = userRepository.findByUserName(userName);

        List<UserSearchRes> userSearchResList = new ArrayList<>();
        for (UserEntity userEntity : result){
            userSearchResList.add(UserSearchRes.of(userEntity));
        }

        return ResponseData.of(HttpStatus.OK, "성공", userSearchResList);
    }

}
