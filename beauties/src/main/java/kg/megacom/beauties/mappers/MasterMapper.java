package kg.megacom.beauties.mappers;

import kg.megacom.beauties.models.dtos.MasterDto;
import kg.megacom.beauties.models.entities.Master;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MasterMapper extends BaseMapper<Master, MasterDto> {
    MasterMapper INSTANCE = Mappers.getMapper(MasterMapper.class);
}
