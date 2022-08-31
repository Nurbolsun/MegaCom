package com.company;

public class Shark extends Animal implements Eating {
    public Shark(String name, String type, boolean hasTail, int countPaws) {
        super(name, type, hasTail, countPaws);
    }

    void dangerLevels() {
        System.out.println("Dangerous");
    }

    @Override
    public void eat() {
        System.out.println("Eating: Fish ");
    }
}
