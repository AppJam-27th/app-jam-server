package appJam.hackerton.appjam_27.domain.time.dto.res;

import appJam.hackerton.appjam_27.domain.time.entity.TimeEntity;

import java.time.LocalDate;

public record TimeRes (
        String userId,
        Long userTime,
        LocalDate localDate
){
    public static TimeRes of(TimeEntity timeEntity) {
        return new TimeRes(timeEntity.getUserId().getUserId(), timeEntity.getUserTime(), timeEntity.getCreatedDate());
    }
}
