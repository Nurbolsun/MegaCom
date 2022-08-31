package com.company;

public class Main {

    public static void main(String[] args) {

        Specialist specialist = new Specialist();
        Developer developer = new Developer();
        Manager manager = new Manager();
        CEO ceo = new CEO();

        specialist.setFirstName("Baiel");
        specialist.setLastName("Ryskulbekov");
        specialist.setAge(18);
        specialist.setSalary(15000);

        System.out.println(specialist);
        specialist.workWithClients();
        specialist.setLevels(45);
        System.out.println(specialist.getLevels());

        specialist.setFirstName("Baktilek");
        specialist.setLastName("Taalaibek uulu");
        specialist.setAge(28);
        specialist.setSalary(40000);

        System.out.println(specialist);
        specialist.workWithClients();
        specialist.setLevels(92);
        System.out.println(specialist.getLevels());

        specialist.setFirstName("Adil");
        specialist.setLastName("Jandaev");
        specialist.setAge(33);
        specialist.setSalary(50000);

        System.out.println(specialist);
        specialist.workWithClients();
        specialist.setLevels(90);
        System.out.println(specialist.getLevels());

    }
}
