package com.company;

import java.util.Scanner;

public class Change {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte choose ;
        float b, kb;
        System.out.println("Выберите : \n1)Byte to Kbyte \n2)Kbyt to Byte ");
        choose=scan.nextByte();
        if (choose == 1){
            System.out.println("Введите число:");
            b = scan.nextInt();
            System.out.println(b/1024 + " kbyte ");
        }else {
            System.out.println("Введите число:");
            kb = scan.nextInt();
            System.out.println(kb*1024 + " byte ");
        }

    }
}
