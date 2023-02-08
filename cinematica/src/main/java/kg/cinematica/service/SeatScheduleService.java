package kg.cinematica.service;

import kg.cinematica.models.dto.SeatScheduleDto;
import kg.cinematica.models.entities.SeatSchedule;
import kg.cinematica.models.requests.SeatScheduleRequest;
import kg.cinematica.models.response.SeatScheduleResponse;

import java.util.List;

public interface SeatScheduleService extends BaseService<SeatScheduleDto>{
    SeatScheduleDto create(Long roomMovieId, List<Long> seatsId);
    List<SeatScheduleDto> findByRoomMovieId(Long roomMovieId);
    List<SeatScheduleDto> findByRoomMovieAndSeatsId(Long roomMovieId);
    List<SeatScheduleResponse> getRoomMovieId(Long getroomMovieId);
}
