package kg.mega.saloon.service;

import kg.mega.saloon.models.dto.OrderDto;
import kg.mega.saloon.models.requests.OrderRequest;
import kg.mega.saloon.models.responses.Response;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface OrderService extends BaseService<OrderDto>{

    Response create(OrderRequest orderRequest) throws ParseException;
    Response confirm(int code);
    void checkSuspendOrders();
    List<OrderDto> findOrderByMaster_Id(Long masterId);
    boolean checkDate(Date updateDate);
    OrderDto findOrderByConfirmCode(int confirmCode);
    Response saveAll(List<OrderDto> list);
}
