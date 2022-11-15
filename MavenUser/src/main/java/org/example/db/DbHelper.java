package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

    private final  String url = "jdbc:posgresql://localhost/tinder_db";
    private final String user = "postgres";
    private final String password = "postgres";

    public Connection connec(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

}
