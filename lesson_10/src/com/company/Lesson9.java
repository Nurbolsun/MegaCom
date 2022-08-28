package com.company;

import java.util.Scanner;

public class Lesson9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Количество студентов: ");
        int sizeArray = scanner.nextInt();

        String[] names = new String[sizeArray];
        int[] ages = new int[sizeArray];
        double result = 0;

        for (int i = 0; i < names.length; i++) {
            System.out.println("Имя студента: ");
            String name = scanner.next();
            names[i] = name;
        }
        for (int i = 0; i < ages.length; i++) {
            System.out.println("Возраст " + names[i]);
            int age = scanner.nextInt();
            ages[i] = age;
            result += age;
        }

        for (int i = 0; i < names.length; i++) {
            System.out.println("Имя " + names[i] + " Возраст " + ages[i]);

        }
        System.out.println("Средне арифметическое " + result / ages.length);
    }
}