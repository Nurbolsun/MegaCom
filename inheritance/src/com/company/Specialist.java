package com.company;

public class Specialist extends Employee{

    public int levels = 99;

    public  void  workWithClients(){
        System.out.println("I am writing my awesome algoritm!");
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }
}
