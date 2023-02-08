package kg.cinematica.service;

import kg.cinematica.models.dto.RoomMovieDto;
import kg.cinematica.models.requests.RoomMovieRequest;
import kg.cinematica.models.response.Response;

import java.time.LocalDate;
import java.util.List;

public interface RoomMovieService extends BaseService<RoomMovieDto> {
    Response create(RoomMovieRequest roomMovieRequest);
    List<RoomMovieDto> findRoomMovieByMovieId(Long movieId, LocalDate startDate);
}
