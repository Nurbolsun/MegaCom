package kg.cinematica.mappers;

import kg.cinematica.models.dto.MovieDto;
import kg.cinematica.models.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MovieMapper extends BaseMapper<Movie, MovieDto>{
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
}
