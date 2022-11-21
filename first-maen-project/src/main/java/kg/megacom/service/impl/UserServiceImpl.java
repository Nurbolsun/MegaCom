package kg.megacom.service.impl;

import kg.megacom.dao.UserRep;
import kg.megacom.dao.impl.UserRepImpl;
import kg.megacom.models.User;
import kg.megacom.models.enums.UserStatus;
import kg.megacom.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    UserRep userRep = UserRep.INSTANCE;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void createTable() throws SQLException {
        userRep.createTable();
    }

    @Override
    public User createUser() {
        User newUser = new User();
        System.out.println("Пройдите регистрацию");
        System.out.println("Ваше имя: ");
        newUser.setName(scanner.next());
        System.out.println("Сколько вам лет: ");
        newUser.setAge(scanner.nextInt());
        System.out.println("Опишите себя ");
        newUser.setDefinition(scanner.next());
        System.out.println("Ваш email ");
        newUser.setEmail(scanner.next());
        newUser.setStatus(UserStatus.NEW);

        //сохраняем нового пользователя в базу
        System.out.println();
        System.out.println("Пользователь успешно создан");
        try {
            userRep.save(newUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return findByEmail(newUser.getEmail());
    }

    @Override
    public List<User> getAllUsers() {
        return userRep.getAllUsers();
    }

    @Override
    public User userAuth() {
        User foundUser = null;
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Введите вашу почту");
            String usersLogin = scanner.next();
            foundUser = findByEmail(usersLogin);
            if (foundUser.getId() != null) {
                break;
            } else {
                System.out.println("Пользователь не найдет повторите еще ");
            }
        }
        return foundUser;
    }

    @Override
    public User findByEmail(String email) {
        try {
            User user = userRep.findByEmail(email);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean changeStatus(User user, int userStatusCode) {
        return false;
    }




}
