package kg.cinematica.service;

import kg.cinematica.enums.Type;
import kg.cinematica.models.dto.OrderDetailDto;
import kg.cinematica.models.dto.OrderDto;
import kg.cinematica.models.requests.OrderRequest;
import kg.cinematica.models.response.OrderResponse;

import java.util.List;
import java.util.Map;

public interface OrderService extends BaseService<OrderDto> {
    OrderDto create();
    OrderResponse book(Long roomMovieId, Map<Long,Type> seatAndPrice);
    OrderResponse getOrderDetail(List<OrderDetailDto> orderDetailDtoList);

}
