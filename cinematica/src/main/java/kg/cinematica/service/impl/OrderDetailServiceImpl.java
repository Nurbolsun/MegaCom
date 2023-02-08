package kg.cinematica.service.impl;

import kg.cinematica.dao.OrderDetailRep;
import kg.cinematica.mappers.OrderDetailMapper;
import kg.cinematica.models.dto.OrderDetailDto;
import kg.cinematica.models.dto.OrderDto;
import kg.cinematica.models.dto.SeatScheduleDto;
import kg.cinematica.models.requests.OrderDetailRequest;
import kg.cinematica.service.OrderDetailService;
import kg.cinematica.service.OrderService;
import kg.cinematica.service.SeatScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    OrderDetailMapper mapper = OrderDetailMapper.INSTANCE;

    private  final OrderDetailRep rep;
    private final SeatScheduleService seatService;
    private final OrderService orderService;

    public OrderDetailServiceImpl(OrderDetailRep rep, SeatScheduleService seatService, OrderService orderService) {
        this.rep = rep;
        this.seatService = seatService;
        this.orderService = orderService;
    }

    @Override
    public OrderDetailDto save(OrderDetailDto orderDetailDto) {
        return mapper.toDto(rep.save(mapper.toEntity(orderDetailDto)));
    }

    @Override
    public OrderDetailDto findById(Long id) {
        return null;
    }

    @Override
    public OrderDetailDto delete(Long id) {
        OrderDetailDto orderDetailDto = findById(id);
        orderDetailDto.setActive(false);
        return save(orderDetailDto);
    }

    @Override
    public List<OrderDetailDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }


    @Override
    public OrderDetailDto create(OrderDetailRequest orderDetailRequest) {
        SeatScheduleDto seatScheduleDto = seatService.findById(orderDetailRequest.getSeatScheduleId());
        OrderDto orderDto = orderService.findById(orderDetailRequest.getOderId());
        OrderDetailDto detailDto = new OrderDetailDto();
        detailDto.setSeatSchedule(seatScheduleDto);
        detailDto.setOrder(orderDto);
        return save(detailDto);
    }
}
