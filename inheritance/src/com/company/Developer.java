package com.company;

public class Developer extends Employee {

    public String grades = "Middle";

    public  void  writeCode(){
        System.out.println("I am writing my awesome algoritm!");
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }
}
