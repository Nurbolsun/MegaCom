package kg.cinematica.service;

import kg.cinematica.models.dto.OrderDetailDto;
import kg.cinematica.models.requests.OrderDetailRequest;

public interface OrderDetailService extends BaseService<OrderDetailDto>{
    OrderDetailDto create(OrderDetailRequest orderDetailRequest);
}
