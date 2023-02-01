package kg.cinematica.mappers;

import kg.cinematica.models.dto.ScheduleDto;
import kg.cinematica.models.entities.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper extends BaseMapper<Schedule, ScheduleDto> {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);
}
