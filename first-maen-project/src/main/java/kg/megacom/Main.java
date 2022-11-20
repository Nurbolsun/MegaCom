package kg.megacom;

import kg.megacom.models.User;
import kg.megacom.service.OrderService;
import kg.megacom.service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        // creating a new table if doesn't exist
        OrderService orderService = OrderService.INSTANCE;
        orderService.createTable();
        UserService userService = UserService.INSTANCE;
        userService.createTable();


        // Auth , registration
        System.out.println("Задите или пройдите регистрацию");
        System.out.println("1) зарегестрироваться        2) авторизоваться");
        switch (scanner.nextInt()) {
            case 1: {
                System.out.println(user = userService.createUser());
            }
            break;
            case 2: {
                System.out.println(user = userService.userAuth());
            }
            break;
        }

        // Creating order
        System.out.println();
        System.out.println("1)Отправить запрос         2) Посмотреть мои отправленные запросы");
        switch (scanner.nextInt()) {
            case 1: {
               orderService.createOrder(user);
            }
        }



/*        User user = new User();

        user.setName(scanner.nextLine());
        user.setAge(scanner.nextInt());
        user.setDefinition(scanner.next());
        user.setEmail(scanner.next());
        user.setStatus(UserStatus.NEW);

        userService.createUser(user);*/
/*

        User user1 = new User("Dastan", "Open for relationship", 13, "dastanzholdoshkariev@mail.com", UserStatus.NEW);

        userService.createUser(user1);

        List<User> userList = userService.getAllUsers();

        User user = new User();
        userList.stream().forEach(x -> System.out.println(x));
        userList.stream().forEach(x -> {
            if (x.getId() == 13) {
                user.setId(x.getId());
                user.setEmail(x.getEmail());
                user.setDefinition(x.getDefinition());
                user.setAge(x.getAge());
                user.setName(x.getName());
                user.setStatus(x.getStatus());
            }
        });


        Order order = new Order();
        order.setMatch(false);
        order.setMessage("hello");
        order.setStatus("New");
        order.setRecipient_id(user);
        order.setUser_id(user1);


        orderService.createOrder(order);*/
    }
}
