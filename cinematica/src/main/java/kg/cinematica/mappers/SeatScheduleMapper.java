package kg.cinematica.mappers;

import kg.cinematica.models.dto.SeatScheduleDto;
import kg.cinematica.models.entities.SeatSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface SeatScheduleMapper extends BaseMapper<SeatSchedule, SeatScheduleDto>{
    SeatScheduleMapper INSTANCE = Mappers.getMapper(SeatScheduleMapper.class);
}
