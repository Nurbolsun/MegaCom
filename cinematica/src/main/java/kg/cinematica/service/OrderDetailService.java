package kg.cinematica.service;

import kg.cinematica.models.dto.OrderDetailDto;
import kg.cinematica.models.requests.OrderDetailRequest;
import kg.cinematica.models.response.OrderDetailResponse;

import java.util.List;

public interface OrderDetailService extends BaseService<OrderDetailDto>{
    OrderDetailDto create(OrderDetailRequest orderDetailRequest);
    List<OrderDetailResponse> getOrderDetailResponse(Long orderDetailId);
    List<OrderDetailDto> findByOrderId (Long orderId);
}
