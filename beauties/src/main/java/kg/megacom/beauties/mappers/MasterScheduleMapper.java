package kg.megacom.beauties.mappers;

import kg.megacom.beauties.models.dtos.MasterScheduleDto;
import kg.megacom.beauties.models.entities.MasterSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MasterScheduleMapper extends BaseMapper<MasterSchedule, MasterScheduleDto> {
    MasterScheduleMapper INSTANCE = Mappers.getMapper(MasterScheduleMapper.class);
}
