package kg.cinematica.service.impl;

import kg.cinematica.dao.OrderDetailRep;
import kg.cinematica.mappers.OrderDetailMapper;
import kg.cinematica.models.dto.OrderDetailDto;
import kg.cinematica.models.dto.OrderDto;
import kg.cinematica.models.dto.SeatScheduleDto;
import kg.cinematica.models.entities.Order;
import kg.cinematica.models.requests.OrderDetailRequest;
import kg.cinematica.models.response.OrderDetailResponse;
import kg.cinematica.service.OrderDetailService;
import kg.cinematica.service.OrderService;
import kg.cinematica.service.PriceService;
import kg.cinematica.service.SeatScheduleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    OrderDetailMapper mapper = OrderDetailMapper.INSTANCE;

    private final OrderDetailRep rep;
    private final PriceService priceService;

    public OrderDetailServiceImpl(OrderDetailRep rep, PriceService priceService) {
        this.rep = rep;
        this.priceService = priceService;
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
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        return save(orderDetailDto);
    }

    @Override
    public List<OrderDetailResponse> getOrderDetailResponse(Long orderDetailId) {
        List<OrderDetailDto> orderDetailDtoList = findByOrderId(orderDetailId);
        List<OrderDetailResponse> orderDetailResponseList = new ArrayList<>();
        for (OrderDetailDto item: orderDetailDtoList){
            OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
            orderDetailResponse.setOrderId(orderDetailDtoList.get(0).getOrder().getId());
            orderDetailResponse.setCinema(orderDetailDtoList.get(0).getSeatSchedule().getRoomMovie().getRoom().getCinema().getName());
            orderDetailResponse.setMovie(orderDetailDtoList.get(0).getSeatSchedule().getRoomMovie().getMovie().getName());
            orderDetailResponse.setRoom(orderDetailDtoList.get(0).getSeatSchedule().getRoomMovie().getRoom().getName());
            orderDetailResponse.setStartDate(orderDetailDtoList.get(0).getSeatSchedule().getRoomMovie().getSchedule().getStartDate());
            orderDetailResponse.setStartTime(orderDetailDtoList.get(0).getSeatSchedule().getRoomMovie().getSchedule().getStartTime());

            orderDetailResponse.setRow(item.getSeatSchedule().getSeat().getRow());
            orderDetailResponse.setNum(item.getSeatSchedule().getSeat().getNum());
            orderDetailResponse.setPriceType(item.getPriceType());
            int price = priceService.getPrice(item.getPriceType());
            orderDetailResponse.setPrice(price);
            orderDetailResponseList.add(orderDetailResponse);
        }
        return orderDetailResponseList;
    }

    @Override
    public List<OrderDetailDto> findByOrderId(Long orderId) {
        return mapper.toDtos(rep.findByOrderId(orderId));
    }
}
