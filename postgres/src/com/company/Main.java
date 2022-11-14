package com.company;

import com.company.db.DBHelper;
import com.company.db.impl.DBHelperImpl;
import com.company.models.Teachers;
import com.sun.jdi.connect.spi.Connection;

import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DBHelper dbHelper = new DBHelperImpl();
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Имя преподавателя: ");
//        Teachers teachers = new Teachers(scanner.next());
//        dbHelper.createTeacher(teachers);

//        System.out.println("Введите id преподавателя");
//        Teachers teachers = dbHelper.getById(scanner.nextLong());
//        System.out.println(teachers);

        while (true){
            System.out.println("Какую операцию вы желаете провести?");
            System.out.println("Сохранение 1, Вывод по id 2, Вывод списка 3, Удаление 4");

            switch (scanner.nextInt()){
                case 1:
                    System.out.println("Имя преподавателя: ");
                    dbHelper.createTeacher(new Teachers(scanner.next()));
                    break;
                case 2:
                    System.out.println("Введите id преподавателя");
                    System.out.println(dbHelper.getById(scanner.nextLong()));
                    break;
                case 3:
                    System.out.println("Список преподавателей");
                    System.out.println(dbHelper.getAll());
                    break;
                case 4:
                    System.out.println("Введите id преподавателя для удаление");
                    dbHelper.deleteTeacher(scanner.nextLong());

            }
        }
    }
}
