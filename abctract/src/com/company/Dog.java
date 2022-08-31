package com.company;

public class Dog extends Animal implements Working {
    public Dog(String name, String type, boolean hasTail, int countPaws) {
        super(name, type, hasTail, countPaws);
    }

    @Override
    public void work() {
        System.out.println("Working");
    }
}
