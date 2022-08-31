package com.company;

import javax.xml.transform.Result;

public class Main {

    public static void main(String[] args) {

        Eagle eagle1 = new Eagle("Eagle-1", "Bird", true, 2);
        Eagle eagle2 = new Eagle("Eagle-2", "Bird", true, 2);

        Dog dog = new Dog("LAika", "Dog", true, 4);
        Dog dog1 =new Dog("Bobik", "Dog", false, 4);

        Ant ant =new Ant("Ant-1", "Ants", false,6);
        Ant ant1 = new Ant("Ant-2", "Ants", false, 8);

        Shark shark = new Shark("Shark-1", "Fish", true, 0);
        Shark shark1 = new Shark("Shark-2", "Fish", false, 0);

        Animal[] animals = {eagle1,eagle2,dog,dog1,ant,ant1,shark,shark1};
        for (Animal iteam:animals){
            System.out.println("Name:" + iteam.name + " Type:" + iteam.type + " HasTail:" + iteam.hasTail + " CountPAws:" + iteam.countPaws);
        }
        shark.dangerLevels();

    }
}
