package kg.cinematica.mappers;

import kg.cinematica.models.dto.RoomMoviePriceDto;
import kg.cinematica.models.entities.RoomMoviePrice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMoviePriceMapper extends BaseMapper<RoomMoviePrice, RoomMoviePriceDto> {
    RoomMoviePriceMapper INSTANCE = Mappers.getMapper(RoomMoviePriceMapper.class);
}
