package kg.megacom.dao.impl;

import kg.megacom.dao.DbHelperRep;
import kg.megacom.dao.OrderRep;
import kg.megacom.models.Order;
import kg.megacom.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderRepImpl implements OrderRep {
    DbHelperRep dbHelperRep = DbHelperRep.INSTANCE;

    public void createTable() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "orders"
                + "  (id           INTEGER,"
                + "   user_id            INTEGER ,"
                + "   recipient_id          INTEGER,"
                + "   status           VARCHAR(50),"
                + "   match           INTEGER ,"
                + "   message     VARCHAR(255))";

        try (Statement stmt = dbHelperRep.connect().createStatement()) {
            stmt.execute(sqlCreate);
        }
    }

    @Override
    public void save(Order order) {
        try (PreparedStatement sqlInsert = dbHelperRep.connect().prepareStatement("INSERT INTO orders (user_id," +
                "recipient_id, status, match, message) VALUES(?,?,?,?,?)")) {

            sqlInsert.setLong(1, order.getUserId().getId());
            sqlInsert.setLong(2, order.getRecipientId().getId());
            sqlInsert.setString(3, order.getStatus());
            sqlInsert.setBoolean(4, order.isMatch());
            sqlInsert.setString(5, order.getMessage());
            sqlInsert.execute();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();
        }
    }

    @Override
    public Order check(Long userId, Long recipient) {
        try (PreparedStatement preparedStatement=dbHelperRep.connect().
                prepareStatement("SELECT * FROM orders o where o.user_id=? and o.recipient_id=?")){
            preparedStatement.setLong(1,userId);
            preparedStatement.setLong(2,recipient);
            ResultSet resultSet=preparedStatement.executeQuery();
            Order order = new Order();
            while (resultSet.next()){
                order.setUserId(new User(resultSet.getLong("user_id")));
                order.setRecipientId(new User(resultSet.getLong("recipient_id")));
                order.setStatus(resultSet.getString("status"));
                order.setMatch(resultSet.getBoolean("match"));
                order.setMessage(resultSet.getString("message"));
            }
            return order;
        }catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throw new RuntimeException("");
        }
    }
}

