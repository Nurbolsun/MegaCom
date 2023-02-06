package kg.cinematica.mappers;

import kg.cinematica.models.dto.PriceDto;
import kg.cinematica.models.entities.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PriceMapper extends BaseMapper<Price, PriceDto> {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
}
