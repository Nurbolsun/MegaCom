package com.company;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        Snake snake = new Snake();
        snake.setPoisonLevel(99);

        dog.setCountPaws(4);
        dog.setHasTail(true);
        dog.setName("Laika");
        dog.setType("DOg");

        Cat cat = new Cat();

        cat.setCountPaws(5);
        cat.setHasTail(false);
        cat.setName("Barsik");
        cat.setType("Cat");

        System.out.println(dog);
        System.out.println(cat);
        System.out.println("Dog " + dog.getVoice());
        System.out.println("CAt " + cat.getVoice());
    }
}
