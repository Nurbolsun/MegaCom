package kg.mega.saloon.service;

import kg.mega.saloon.models.dto.OrderDto;
import kg.mega.saloon.models.requests.OrderRequest;
import kg.mega.saloon.models.responses.Response;

import javax.mail.MessagingException;
import java.io.IOException;

public interface OrderService extends BaseService<OrderDto>{

  void emailSender(String email) throws IOException, MessagingException;

    Response create(OrderRequest order);
}
