package kg.cinematica.mappers;

import kg.cinematica.models.dto.OrderDto;
import kg.cinematica.models.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderDto>{
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
}
