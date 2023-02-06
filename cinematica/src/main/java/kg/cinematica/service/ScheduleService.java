package kg.cinematica.service;

import kg.cinematica.models.dto.ScheduleDto;
import kg.cinematica.models.requests.ScheduleRequest;

import java.time.LocalTime;
import java.util.Date;

public interface ScheduleService extends BaseService<ScheduleDto>{
    ScheduleDto create (Date addDate, LocalTime startTime);
}
