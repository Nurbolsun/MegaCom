package kg.cinematica.mappers;

import kg.cinematica.models.dto.OrderDetailDto;
import kg.cinematica.models.entities.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail, OrderDetailDto> {
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);
}
