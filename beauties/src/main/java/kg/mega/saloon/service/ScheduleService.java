package kg.mega.saloon.service;

import kg.mega.saloon.enums.WorkDayEnum;
import kg.mega.saloon.models.dto.ScheduleDto;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface ScheduleService extends BaseService<ScheduleDto>{

    ScheduleDto create(WorkDayEnum workDayEnum, LocalTime startTime, LocalTime endTime);

    List<ScheduleDto> findScheduleByMasterId(Long id);
    Map<WorkDayEnum,String> scheduleMap(Long masterId);
    ScheduleDto create(LocalTime startTime, LocalTime endTime, WorkDayEnum workDay);
}
