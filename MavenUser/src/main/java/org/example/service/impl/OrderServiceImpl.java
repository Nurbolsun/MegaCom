package org.example.service.impl;

import org.example.dao.OrderRep;
import org.example.service.OrderService;

import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {
    OrderRep orderRep = OrderRep.INSTANCE;

    @Override
    public void createTable() throws SQLException {

    }
}
