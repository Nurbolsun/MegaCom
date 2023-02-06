package kg.cinematica.service;

import kg.cinematica.models.dto.CinemaDto;
import kg.cinematica.models.requests.CinemaRequest;

public interface CinemaService extends BaseService<CinemaDto> {
    CinemaDto create(CinemaRequest cinemaRequest);
}
