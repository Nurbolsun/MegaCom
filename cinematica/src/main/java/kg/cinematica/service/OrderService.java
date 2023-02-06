package kg.cinematica.service;

import kg.cinematica.models.dto.OrderDto;
import kg.cinematica.models.requests.OrderRequest;

public interface OrderService extends BaseService<OrderDto> {
    OrderDto create(OrderRequest orderRequest);
}
