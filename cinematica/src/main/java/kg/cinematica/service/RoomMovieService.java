package kg.cinematica.service;

import kg.cinematica.models.dto.RoomMovieDto;
import kg.cinematica.models.requests.RoomMovieRequest;

public interface RoomMovieService extends BaseService<RoomMovieDto> {
    RoomMovieDto create(RoomMovieRequest roomMovieRequest);
}
