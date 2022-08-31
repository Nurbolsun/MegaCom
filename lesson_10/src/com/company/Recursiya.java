package com.company;

public class Recursiya {
    public static void main(String[] args) {
        say(12);
    }
    static void say(int counter){
        if (counter == 0){
            return;
        }
        System.out.println("Hello!");
        say(counter -1);
    }
}
