package appJam.hackerton.appjam_27.domain.user.service;

import appJam.hackerton.appjam_27.domain.user.dto.req.UserReq;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import appJam.hackerton.appjam_27.domain.user.repository.UserRepository;
import appJam.hackerton.appjam_27.global.exception.custom.user.AlreadyExistUser;
import appJam.hackerton.appjam_27.global.exception.custom.user.NotFoundUserException;
import appJam.hackerton.appjam_27.global.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

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

}
