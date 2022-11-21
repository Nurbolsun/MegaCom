package kg.megacom.service;

import kg.megacom.models.Order;
import kg.megacom.models.User;
import kg.megacom.service.impl.OrderServiceImpl;

import java.sql.SQLException;

public interface OrderService {
    OrderService INSTANCE = new OrderServiceImpl();

    void createTable()throws SQLException;

    Order createOrder(User user);

    void save(Order order);

}
