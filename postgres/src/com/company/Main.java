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

//        System.out.println("��� �������������: ");
//        Teachers teachers = new Teachers(scanner.next());
//        dbHelper.createTeacher(teachers);

//        System.out.println("������� id �������������");
//        Teachers teachers = dbHelper.getById(scanner.nextLong());
//        System.out.println(teachers);

        while (true){
            System.out.println("����� �������� �� ������� ��������?");
            System.out.println("���������� 1, ����� �� id 2, ����� ������ 3, �������� 4");

            switch (scanner.nextInt()){
                case 1:
                    System.out.println("��� �������������: ");
                    dbHelper.createTeacher(new Teachers(scanner.next()));
                    break;
                case 2:
                    System.out.println("������� id �������������");
                    System.out.println(dbHelper.getById(scanner.nextLong()));
                    break;
                case 3:
                    System.out.println("������ ��������������");
                    System.out.println(dbHelper.getAll());
                    break;
                case 4:
                    System.out.println("������� id ������������� ��� ��������");
                    dbHelper.deleteTeacher(scanner.nextLong());

            }
        }
    }
}
