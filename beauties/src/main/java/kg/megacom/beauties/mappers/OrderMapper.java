package kg.megacom.beauties.mappers;

import kg.megacom.beauties.models.dtos.OrderDto;
import kg.megacom.beauties.models.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Sort;
@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderDto> {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
}
