package kg.cinematica.mappers;

import kg.cinematica.models.dto.SeatDto;
import kg.cinematica.models.entities.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface SeatMapper extends BaseMapper<Seat, SeatDto> {
    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);
}
