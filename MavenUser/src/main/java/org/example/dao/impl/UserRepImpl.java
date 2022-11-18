package org.example.dao.impl;

import org.example.dao.DbHelperRep;
import org.example.dao.UserRep;
import org.example.models.User;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserRepImpl implements UserRep {
    DbHelperRep dbHelperRep = DbHelperRep.INSTANCE;


    @Override
    public void createTable() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "users"
                + "(id INTEGER,"
                + "name VARCHAR(50),"
                + "age INTEGER, "
                + "definition VARCHAR(255),"
                + "email VARCHAR(255),"
                + "status VARCHAR(50))";
        try(Statement stmt = DbHelperRep.connect().createStatement()) {
                stmt.execute(sqlCreate);
                stmt.close();
        }
    }

    @Override
    public void save(User user) throws SQLException {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
