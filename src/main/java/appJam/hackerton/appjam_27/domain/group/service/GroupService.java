package appJam.hackerton.appjam_27.domain.group.service;

import appJam.hackerton.appjam_27.domain.group.entity.GroupEntity;
import appJam.hackerton.appjam_27.domain.group.repository.GroupRepository;
import appJam.hackerton.appjam_27.domain.user.dto.req.UserReq;
import appJam.hackerton.appjam_27.domain.user.entity.UserEntity;
import appJam.hackerton.appjam_27.global.exception.custom.user.AlreadyExistUser;
import appJam.hackerton.appjam_27.global.exception.custom.user.NotFoundUserException;
import appJam.hackerton.appjam_27.global.response.Response;
import lombok.RequiredArgsConstructor;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;


    public List<GroupEntity> search(String groupname) {
        List<GroupEntity> groupNm = groupRepository.findByGroupName(groupname);
         
        return groupNm;
    }

}