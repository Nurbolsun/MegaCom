package kg.cinematica.service;

import kg.cinematica.models.dto.SeatScheduleDto;
import kg.cinematica.models.requests.SeatScheduleRequest;

public interface SeatScheduleService extends BaseService<SeatScheduleDto>{
    SeatScheduleDto create(SeatScheduleRequest seatScheduleRequest);
}
