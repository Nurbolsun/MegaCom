package kg.megacom.dao;

import kg.megacom.dao.impl.OrderRepImpl;
import kg.megacom.models.Order;

import java.sql.SQLException;

public interface OrderRep {
    OrderRep INSTANCE = new OrderRepImpl();

    void createTable() throws SQLException;

    void save(Order order);
}
