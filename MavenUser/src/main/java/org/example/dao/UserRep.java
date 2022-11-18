package org.example.dao;

import org.example.dao.impl.UserRepImpl;

import java.sql.SQLException;
import java.util.List;

public interface UserRep {
    UserRep INSTANCE = new UserRepImpl();
    void createTable() throws SQLException;
    void save(User user) throws SQLException;
    List<User> getAllUsers();
}
