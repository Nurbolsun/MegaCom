package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double result = 0;
        char choose;
        double num1, num2;
        int i = 0;

        while (true) {
            if (i != 0) {
                num1 = result;
            } else {
                System.out.println("Введите первое число:");
                num1 = scan.nextDouble();
            }
            i = i + 1;
            System.out.println("Выберите операции:");
            choose = scan.next().charAt(0);

            if (choose == '='){
                System.out.println("Ваш ответ: " + result);
                break;
            }

            System.out.println("Введите второе число:");
            num2 = scan.nextDouble();

            switch (choose) {
                case '+':
                    result = num1 + num2;
                    System.out.println(result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println(result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println(result);
                case '/':
                    result = num1 / num2;
                    System.out.println(result);
            }
        }
    }
}
