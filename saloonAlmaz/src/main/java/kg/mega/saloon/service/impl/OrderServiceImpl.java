package kg.mega.saloon.service.impl;

import kg.mega.saloon.dao.MasterRep;
import kg.mega.saloon.dao.OrderRep;
import kg.mega.saloon.mappers.MasterMapper;
import kg.mega.saloon.mappers.OrderMapper;
import kg.mega.saloon.models.dto.MasterDto;
import kg.mega.saloon.models.dto.OrderDto;
import kg.mega.saloon.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRep rep;
    OrderMapper mapper = OrderMapper.INSTANCE;


    @Override
    public OrderDto save(OrderDto order) {
        return mapper.toDto(rep.save(mapper.toEntity(order)));
    }

    @Override
    public OrderDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Заявка не найдена!")));
    }

    @Override
    public OrderDto delete(Long id) {
        OrderDto order = findById(id);
        //?????
        return null;
    }

    @Override
    public List<OrderDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }
}
