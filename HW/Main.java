package com.company;
public class Main {
    public static void main(String[] args) {
        int max = 100;
        int min = 1;
        int range = max - min + 1;
        int maxN=0;
        int minN=100;
        for (int i = 0; i < 100; i++) {
            int rand = (int) (Math.random() * range) + min;
            if (rand > maxN) {
                maxN = rand;
            }
            if (rand < minN) {
                minN = rand;
            }
        }
        System.out.println("Max: " + maxN);
        System.out.println("Min: " + minN);
    }
}
