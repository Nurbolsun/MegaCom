package kg.megacom.service.impl;

import kg.megacom.dao.OrderRep;
import kg.megacom.models.Order;
import kg.megacom.models.User;
import kg.megacom.service.OrderService;
import kg.megacom.service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    OrderRep orderRep = OrderRep.INSTANCE;
    UserService userService = UserService.INSTANCE;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void createTable() throws SQLException {
        orderRep.createTable();
    }

    private List<User> checkIfOrderExists(List<User> userList) {


        return userList;
    }

    @Override
    public Order createOrder(User user) {
        Order orderNew = new Order();

        int scannedNum;

        System.out.println("Вывберите пользователя из списка!");
        AtomicInteger counter = new AtomicInteger(1);
        List<User> userList = userService.getAllUsers();

        List<User> selectedUserList = userList.stream().filter(x -> x.getId() != user.getId()).collect(Collectors.toList());

        selectedUserList.forEach(x -> {
            System.out.print(counter.get());
            System.out.println(": Имя - " + x.getName());
            System.out.println("Описание - " + x.getDefinition());
            System.out.println("Возраст - " + x.getAge());
            System.out.println();
            counter.getAndIncrement();
        });

        scannedNum = scanner.nextInt();
        User selectedUser = selectedUserList.get(scannedNum -1);
        System.out.println("Вы выбрали " + selectedUser.getName());
        orderNew.setRecipientId(selectedUser);
        System.out.println("Ваше тайное сообщение");
        orderNew.setMessage(scanner.next());
        orderNew.setMatch(false);
        orderNew.setStatus("Новый");
        orderNew.setUserId(user);
        save(orderNew);

        System.out.println("Запрос успешно создан!!");
        return orderNew;
    }

    @Override
    public void save(Order order) {
        orderRep.save(order);
    }

    @Override
    public Order checkSpam(Long userId, Long recipient) {
        return orderRep.check(userId,recipient);
    }

}
