package kg.megacom.service;

import kg.megacom.models.User;
import kg.megacom.service.impl.UserServiceImpl;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.List;

public interface UserService {

    UserService INSTANCE = new UserServiceImpl();

    void createTable()throws SQLException;

    User createUser();

    List<User> getAllUsers();

    User userAuth();

    User findByEmail(String email) throws SQLException;

    boolean changeStatus(User user, int userStatusCode);


}
