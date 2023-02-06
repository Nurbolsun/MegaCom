package kg.cinematica.service;

import kg.cinematica.dao.MovieRep;
import kg.cinematica.models.dto.MovieDto;
import kg.cinematica.models.entities.Movie;
import kg.cinematica.models.requests.MovieRequest;
import kg.cinematica.models.response.MovieResponse;

import java.util.List;

public interface MovieService extends BaseService<MovieDto>{
    MovieDto create(MovieRequest movieRequest);
    List<MovieDto> findAllActiveWithLimitOffset (int limit, int offset);
}
