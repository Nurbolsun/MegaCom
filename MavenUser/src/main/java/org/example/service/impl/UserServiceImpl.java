package org.example.service.impl;

import org.example.models.User;
import org.example.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public void createTable() throws SQLException {

    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public boolean changeStatus(User user, int userServiceCode) {
        return false;
    }
}
