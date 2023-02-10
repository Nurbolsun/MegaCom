package kg.cinematica.service;

import kg.cinematica.models.dto.SeatDto;
import kg.cinematica.models.requests.SeatRequest;
import kg.cinematica.models.response.Response;

import java.util.List;

public interface SeatService extends BaseService<SeatDto> {
    Response create(SeatRequest seatRequest);
    List<SeatDto> findSeatsByRoomId(Long roomMovieId);

}
