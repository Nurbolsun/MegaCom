package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Количество студентов :");
        byte students = scan.nextByte();

        String[] names = new String[students];

        for (int i = 0; i < names.length; i++) {
            System.out.println("Имя : ");
            String name = scan.next();
            names[i] = name;
        }
        byte ages[] = new byte[students];

        int sum = 0;
        for (int i = 0; i < ages.length; i++) {
            System.out.println("Возрасть " + names[i] + ": " );
            byte age = scan.nextByte();
            ages[i] = age;
            sum += ages[i];
        }
            for (int i = 0; i < names.length; i++) {

                System.out.println("Имя : " + names[i] + ages[i]);

        }
        System.out.println("Средний возраст: " + sum / students);
    }
}
