package kg.megacom.beauties.services.impl;

import kg.megacom.beauties.dao.OrderRep;
import kg.megacom.beauties.mappers.OrderMapper;
import kg.megacom.beauties.models.dtos.OrderDto;
import kg.megacom.beauties.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRep rep;
    OrderMapper mapper = OrderMapper.INSTANCE;

    @Override
    public OrderDto save(OrderDto orderDto) {
        return mapper.toDto(rep.save(mapper.toEntity(orderDto)));
    }

    @Override
    public OrderDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Заявка не найдена!")));
    }

    @Override
    public OrderDto delete(Long id) {
        OrderDto order = findById(id);
        order.setActive(false);
        return save(order);
    }

    @Override
    public List<OrderDto> findAll() {
        return OrderMapper.INSTANCE.toDtos(rep.findAll());
    }
}
