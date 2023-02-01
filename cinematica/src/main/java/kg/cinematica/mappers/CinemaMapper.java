package kg.cinematica.mappers;

import kg.cinematica.models.dto.CinemaDto;
import kg.cinematica.models.entities.Cinema;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CinemaMapper extends BaseMapper<Cinema, CinemaDto> {
    CinemaMapper INSTANCE = Mappers.getMapper(CinemaMapper.class);
}
