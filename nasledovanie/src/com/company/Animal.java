package com.company;

public class Animal {
    public String name;
    private String type;
    private boolean hasTail;
    private int countPaws;

    public String getVoice(){
        return "voice";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasTail() {
        return hasTail;
    }

    public void setHasTail(boolean hasTail) {
        this.hasTail = hasTail;
    }

    public int getCountPaws() {
        return countPaws;
    }

    public void setCountPaws(int countPaws) {
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
