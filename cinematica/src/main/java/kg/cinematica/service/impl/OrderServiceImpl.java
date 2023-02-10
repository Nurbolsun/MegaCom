package kg.cinematica.service.impl;

import kg.cinematica.dao.OrderRep;
import kg.cinematica.enums.Status;
import kg.cinematica.enums.Type;
import kg.cinematica.mappers.OrderMapper;
import kg.cinematica.models.dto.*;
import kg.cinematica.models.entities.Order;
import kg.cinematica.models.requests.OrderRequest;
import kg.cinematica.models.response.OrderResponse;
import kg.cinematica.models.response.SeatResponse;
import kg.cinematica.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRep rep;
    OrderMapper mapper = OrderMapper.INSTANCE;

    @Autowired
    private SeatService seatService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private RoomMovieService roomMovieService;

    @Autowired
    private SeatScheduleService seatScheduleService;

    @Autowired
    private OrderDetailService orderDetailService;

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
    public OrderDto create() {
        OrderDto orderDto = new OrderDto();
        orderDto.setPrice(0);
        return save(orderDto);
    }

    @Override
    public OrderResponse book(Long roomMovieId, Map<Long, Type> seatAndPrice) {
        OrderDto orderDto = create();
        SeatScheduleDto seatScheduleDto = new SeatScheduleDto();
        List<SeatScheduleDto> seatScheduleDtos;
        List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();
        List<Type> priceTypeList = new ArrayList<>();
        for (Map.Entry<Long, Type> entry: seatAndPrice.entrySet()){
            List<Long> seatsId = new ArrayList<>();
            seatsId.add(entry.getKey());
            priceTypeList.add(entry.getValue());
            SeatDto seatDto = seatService.findById(entry.getKey());
            RoomMovieDto roomMovieDto = roomMovieService.findById(roomMovieId);

            seatScheduleDto.setSeat(seatDto);
            seatScheduleDto.setRoomMovie(roomMovieDto);
            seatScheduleDto.setStatus(Status.BOUGHT);
            seatScheduleService.save(seatScheduleDto);

            seatScheduleDtos = seatScheduleService.findByRoomMovieAndSeatsId(roomMovieId, entry.getKey());
            for (SeatScheduleDto item: seatScheduleDtos){
                SeatScheduleDto seatScheduleDto1 = seatScheduleService.findById(item.getId());
                OrderDetailDto orderDetailDto = new OrderDetailDto();
                orderDetailDto.setOrder(orderDto);
                orderDetailDto.setPriceType(entry.getValue());
                orderDetailDto.setSeatSchedule(seatScheduleDto1);
                orderDetailService.save(orderDetailDto);
                orderDetailDtoList.add(orderDetailDto);
            }
        }
        OrderResponse orderResponse = getOrderDetail(orderDetailDtoList);
        return orderResponse;
    }

    @Override
    public OrderResponse getOrderDetail(List<OrderDetailDto> orderDetailDtoList) {
        OrderDto orderDto = orderDetailDtoList.get(0).getOrder();
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(orderDto.getId());
        orderResponse.setMovieName(orderDetailDtoList.get(0).getSeatSchedule().getRoomMovie().getMovie().getName());
        orderResponse.setRoom(orderDetailDtoList.get(0).getSeatSchedule().getRoomMovie().getRoom().getName());
        orderResponse.setCinemaName(orderDetailDtoList.get(0).getSeatSchedule().getRoomMovie().getRoom().getCinema().getName());
        orderResponse.setStartDate(orderDetailDtoList.get(0).getSeatSchedule().getRoomMovie().getSchedule().getStartDate());
        orderResponse.setStartTime(orderDetailDtoList.get(0).getSeatSchedule().getRoomMovie().getSchedule().getStartTime());

        int totalPrice = 0;
        List<SeatResponse> seatRes = new ArrayList<>();
        for (OrderDetailDto item: orderDetailDtoList){
            SeatResponse seatResponse = new SeatResponse();
            seatResponse.setRow(item.getSeatSchedule().getSeat().getRow());
            seatResponse.setNum(item.getSeatSchedule().getSeat().getNum());
            seatRes.add(seatResponse);
            totalPrice+= priceService.getPrice(item.getPriceType());
        }
        orderDto.setPrice(totalPrice);
        save(orderDto);
        orderResponse.setSeatResponses(seatRes);
        orderResponse.setTotalPrice(totalPrice);
        return orderResponse;
    }
}
