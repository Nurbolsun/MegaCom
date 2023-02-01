package kg.cinematica.service;

import kg.cinematica.models.dto.ScheduleDto;

import java.time.LocalTime;

public interface ScheduleService extends BaseService<ScheduleDto>{
    ScheduleDto create (LocalTime startTime);
}
