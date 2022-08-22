package human;

import java.util.Arrays;
import java.util.Scanner;

public class Human {
    private String name;
    private int age;
    private double weight;
    private boolean married;
    private String[] activities;
    private String phoneNumber;
    private float height;
    private boolean isTrue = true;
    Scanner scanner = new Scanner(System.in);

    public void setName(String name) {
        while (isTrue) {
            if (name.length() > 1) {
                this.name = name;
                return;
            } else {
                System.out.println("Incorrect input name");
                name = scanner.nextLine();
            }
        }
    }

    public int setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
            return age;
        } else {
            System.out.println("Incorrect input age");
            age = scanner.nextInt();
            return setAge(age);
        }

    }

    public void setWeight(double weight) {
        this.weight = checkWeight(weight);
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setActivities(String[] activities) {
        Arrays.binarySearch(activities,0, activities.length, null);
        this.activities = activities;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight);
        System.out.println(married);
        System.out.println(Arrays.toString(activities));
        System.out.println(phoneNumber);
        System.out.println(height);
    }

    private double checkWeight(double weight) {
        if (weight > 0 && weight < 200) {
            return weight;
        }
        System.out.println("Incorrect input weight");
        weight = scanner.nextDouble();
        return checkWeight(weight);
    }

}

