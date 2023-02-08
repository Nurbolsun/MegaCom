package kg.cinematica.service;

import kg.cinematica.models.dto.SeatDto;
import kg.cinematica.models.entities.Seat;
import kg.cinematica.models.requests.SeatRequest;

import java.util.List;

public interface SeatService extends BaseService<SeatDto> {
    SeatDto create(SeatRequest seatRequest);
    List<SeatDto> findSeatsByRoomId(Long roomMovieId);

}
