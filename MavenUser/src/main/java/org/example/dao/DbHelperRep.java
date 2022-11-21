package kg.megacom.dao;

import kg.megacom.dao.impl.DbHelperRepImpl;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbHelperRep {
    DbHelperRep INSTANCE = new DbHelperRepImpl();

    Connection connect() throws SQLException;
}
