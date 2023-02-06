package kg.cinematica.service.impl;

import kg.cinematica.dao.OrderRep;
import kg.cinematica.mappers.OrderMapper;
import kg.cinematica.models.dto.OrderDto;
import kg.cinematica.models.dto.UserDto;
import kg.cinematica.models.requests.OrderRequest;
import kg.cinematica.service.OrderService;
import kg.cinematica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRep rep;
    OrderMapper mapper = OrderMapper.INSTANCE;
    @Autowired
    private UserService userService;

    @Override
    public OrderDto save(OrderDto orderDto) {
        return mapper.toDto(rep.save(mapper.toEntity(orderDto)));
    }

    @Override
    public OrderDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Не найдено!")));
    }

    @Override
    public OrderDto delete(Long id) {
        OrderDto orderDto = findById(id);
        orderDto.setActive(false);
        return save(orderDto);
    }

    @Override
    public List<OrderDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public List<OrderDto> sortByDate() {
        return null;
    }

    @Override
    public OrderDto create(OrderRequest orderRequest) {
        UserDto userDto = userService.findById(orderRequest.getUserId());
        OrderDto orderDto = new OrderDto();
        orderDto.setPrice(orderRequest.getPrice());
        orderDto.setStartTime(orderRequest.getStartTime());
        return save(orderDto);
    }
}
