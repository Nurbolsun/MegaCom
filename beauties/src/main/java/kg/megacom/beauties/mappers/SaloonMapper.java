package kg.megacom.beauties.mappers;

import kg.megacom.beauties.models.dtos.SaloonDto;
import kg.megacom.beauties.models.entities.Salon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SaloonMapper extends BaseMapper<Salon, SaloonDto> {
    SaloonMapper INSTANCE = Mappers.getMapper(SaloonMapper.class);
}
