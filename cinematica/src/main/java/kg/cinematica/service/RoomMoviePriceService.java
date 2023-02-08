package kg.cinematica.service;

import kg.cinematica.models.dto.RoomMoviePriceDto;
import kg.cinematica.models.requests.RoomMoviePriceRequest;
import kg.cinematica.models.response.GetRoomMovieResponse;
import kg.cinematica.models.response.Response;

import java.time.LocalDate;
import java.util.List;

public interface RoomMoviePriceService extends BaseService<RoomMoviePriceDto>{
    Response create(Long roomMovieId, List<Long> priceList);
    List<RoomMoviePriceDto> findPriceByMovieId(Long movieId, LocalDate startDate);
    GetRoomMovieResponse getRoomMovieByMovieId (Long movieId, LocalDate startDate);
}
