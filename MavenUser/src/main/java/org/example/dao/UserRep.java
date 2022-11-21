package kg.megacom.dao;

import kg.megacom.dao.impl.UserRepImpl;
import kg.megacom.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRep {
    UserRep INSTANCE = new UserRepImpl();

    void createTable() throws SQLException;

    void save(User user) throws SQLException;

    User findByEmail(String email) throws SQLException;

    List<User> getAllUsers();
}
