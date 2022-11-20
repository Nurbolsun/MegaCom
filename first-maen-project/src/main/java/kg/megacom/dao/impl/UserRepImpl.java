package kg.megacom.dao.impl;

import kg.megacom.dao.DbHelperRep;
import kg.megacom.dao.UserRep;
import kg.megacom.models.User;
import kg.megacom.models.enums.UserStatus;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepImpl implements UserRep {
    DbHelperRep dbHelperRep = DbHelperRep.INSTANCE;

    public void createTable() throws SQLException {


        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "users"
                + "  (id           INTEGER,"
                + "   name            VARCHAR(50),"
                + "   age          INTEGER,"
                + "   definition           VARCHAR(255),"
                + "   email           VARCHAR(100),"
                + "   status     VARCHAR(50))";


        try (Statement stmt = dbHelperRep.connect().createStatement()) {
            stmt.execute(sqlCreate);
        }
    }

    public void save(User user) throws SQLException {
        try (PreparedStatement sqlInsert = dbHelperRep.connect().prepareStatement("INSERT INTO users( name, age," +
                "definition, email, status) VALUES(?,?,?,?,?)")) {


            sqlInsert.setString(1, user.getName());
            sqlInsert.setInt(2, user.getAge());
            sqlInsert.setString(3, user.getDefinition());
            sqlInsert.setString(4, user.getEmail());
            sqlInsert.setString(5, String.valueOf(user.getStatus()));
            sqlInsert.execute();
        }
    }

    @Override
    public User findByEmail(String email) throws SQLException {
        User user = new User();

        try (PreparedStatement sqlStatement = dbHelperRep.connect().prepareStatement("SELECT * FROM users where email = ?")) {
            sqlStatement.setString(1, email);
            ResultSet rs = sqlStatement.executeQuery();
            while (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setDefinition(rs.getString("definition"));
                user.setEmail(rs.getString("email"));
                user.setStatus(UserStatus.valueOf(rs.getString("status")));
            }
        }
        return user;
    }

    public List<User> getAllUsers() {

        List<User> listUser = new ArrayList<>();
        try (PreparedStatement sqlStatement = dbHelperRep.connect().prepareStatement("SELECT * FROM users")) {
            ResultSet rs = sqlStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setDefinition(rs.getString("definition"));
                user.setEmail(rs.getString("email"));
                user.setStatus(UserStatus.valueOf(rs.getString("status")));
                listUser.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listUser;
    }

}
