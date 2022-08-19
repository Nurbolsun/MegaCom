import human.Human;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Human human = new Human();

        System.out.println("Your name: ");
        human.setName(scan.nextLine());

        System.out.println("How old are you: ");
        human.setAge(scan.nextInt());

        System.out.println("How much do you weight? ");
        human.setWeight(scan.nextDouble());

        System.out.println("Are you married? ");
        String questionMarried = scan.next();
        if (questionMarried.equals("yes")){
            human.setMarried(true);
        } else if (questionMarried.equals("no")){
            human.setMarried(false);
        }

        System.out.println("How many hobbies do you have? ");
        String[] activities = new String[scan.nextInt()];
        for (int i = 0; i < activities.length; i++) {
            System.out.println("Your " + (i+1) + " hobby");
            activities[i] = scan.next();
        }
        human.setActivities(activities);

        System.out.println("Your number? ");
        human.setPhoneNumber(scan.next());

        System.out.println("What is your height? ");
        human.setHeight(scan.nextFloat());

    }

}