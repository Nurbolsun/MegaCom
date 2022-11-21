package kg.megacom.dao.impl;

import kg.megacom.dao.DbHelperRep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelperRepImpl implements DbHelperRep {

    private final String url = "jdbc:postgresql://localhost/db_tinder";
    private final String user = "postgres";
    private final String password = "5432";


    public Connection connect() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
