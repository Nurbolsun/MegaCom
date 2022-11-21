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
    }
}
