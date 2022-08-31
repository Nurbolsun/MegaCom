package com.company;

public class Eagle extends Animal implements Eating{
    public Eagle(String name, String type, boolean hasTail, int countPaws) {
        super(name, type, hasTail, countPaws);
    }

    @Override
    public void eat() {
    }
}
