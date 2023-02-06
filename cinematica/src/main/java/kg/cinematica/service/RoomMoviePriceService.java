package kg.cinematica.service;

import kg.cinematica.models.dto.RoomMoviePriceDto;
import kg.cinematica.models.requests.RoomMoviePriceRequest;

public interface RoomMoviePriceService extends BaseService<RoomMoviePriceDto>{
    RoomMoviePriceDto create(RoomMoviePriceRequest roomMoviePriceRequest);
}
