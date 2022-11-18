package org.example.dao;

import org.example.dao.impl.DbHelperRepImpl;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbHelperRep {
    DbHelperRep INSTANCE = new DbHelperRepImpl();
    static Connection connect() throws SQLException;
}
