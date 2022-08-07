package com.company;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String log = "Nurbolsun";
        String pass = "1234n";

        for (int i = 0; i<4 ; i++  ) {
            System.out.println("Введите логин: ");
            String login = scan.next();
            System.out.println("Введите пароль: ");
            String password = scan.next();
            if (login.equals(log) && pass.equals(password)) {
                System.out.println("Авторизация прошла успешно!");
                break;
                }else {
                if (!login.equals(log)){
                    System.out.println("Неверный логин");
                }
                if (!pass.equals(password)){
                    System.out.println("Неверный пароль");
                }
                    System.out.println("Попробуйте еще раз!");
                }
                if (i == 2) {
                    System.out.println("Вы заблокированы!");
                    break;
                }
        }
    }
}
