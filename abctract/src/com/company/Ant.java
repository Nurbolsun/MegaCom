package com.company;

public class Ant extends Animal implements Working{
    public Ant(String name, String type, boolean hasTail, int countPaws) {
        super(name, type, hasTail, countPaws);
    }

    @Override
    public void work() {
        System.out.println("Working");
    }
}
