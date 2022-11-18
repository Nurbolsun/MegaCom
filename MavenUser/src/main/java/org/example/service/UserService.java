package org.example.service;

import org.example.models.User;
import org.example.service.impl.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    UserService INSTANCE = new UserServiceImpl();
    void createTable() throws SQLException;
    User createUser (User user);
    List<User> getAllUser();
    boolean changeStatus(User user, int userServiceCode);
}
