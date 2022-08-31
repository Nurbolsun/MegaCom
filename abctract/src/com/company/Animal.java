package com.company;

public abstract class Animal {
    String name, type;
    boolean hasTail;
    int countPaws;

    public Animal(String name, String type, boolean hasTail, int countPaws) {
        this.name = name;
        this.type = type;
        this.hasTail = hasTail;
        this.countPaws = countPaws;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", hasTail=" + hasTail +
                ", countPaws=" + countPaws +
                '}';
    }
}
