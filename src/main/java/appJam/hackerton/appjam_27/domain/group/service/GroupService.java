package appJam.hackerton.appjam_27.domain.group.service;

import appJam.hackerton.appjam_27.domain.group.entity.GroupEntity;
import appJam.hackerton.appjam_27.domain.group.repository.GroupRepository;
import appJam.hackerton.appjam_27.global.response.Response;
import appJam.hackerton.appjam_27.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public ResponseData<Long> generate(String groupName){
        GroupEntity groupEntity = GroupEntity.builder()
                .groupName(groupName)
                .build();

        groupRepository.save(groupEntity);
        return ResponseData.of(HttpStatus.OK, "성공", groupEntity.getGroupId());
    }


}
