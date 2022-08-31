package com.company;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Количество массивов :");
        int arraySize = scan.nextInt();

        int[] array = new int[arraySize];

        for (int i = 0; i < array.length; i++) {
            int a = i;
            int sum = 0;
            a++;
            System.out.println("Введите " + a++ + " массив");
            int number = scan.nextInt();
            array[i] = number;
        }
        getSum(array);
        getArphSum(array);
        getMax(array);
        getMin(array);
        getEvenNumber(array);
        getOddNumber(array);

    }
    static  void getSum(int[] array){
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Сумма: " + sum);
    }
    static  void getArphSum(int[] array){
        double arphSum = 0;
        for (int i = 0; i < array.length; i++) {
            arphSum += array[i];
        }
        System.out.println("Сред. Ариф всех элементов: " + arphSum / 2);
    }
    static void getMax(int[] array){
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println("Максимальное значение в массиве: " + max);
    }
    static void getMin(int[] array){
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("Минимальное значение в массиве: " + min);
    }
    static void getOddNumber(int[] array){
        int oddSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0)
                oddSum += array[i];
        }
        System.out.println("Сумму всех не четных: " + oddSum);
    }
    static void getEvenNumber(int[] array){
        int evenSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                evenSum += array[i];
        }
        System.out.println("Сумму всех четных: " + evenSum);
    }
}
