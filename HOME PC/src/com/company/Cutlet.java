package com.company;

import java.util.Scanner;

public class Cutlet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k, m, n, result;
        System.out.println("Сколько котлет можно положить в сковороду? ");
        k = scan.nextInt();
        System.out.println("Сколько минут потребуется чтобы обжарить одну сторону ? ");
        m = scan.nextInt();
        System.out.println("Сколько котлет хотите обжарить в общем ? ");
        n = scan.nextInt();

        result = (m*2)*(n/k);
        System.out.println("Ваш " +  n  + " котлет будет готово через " + result + " минут");
    }
}
