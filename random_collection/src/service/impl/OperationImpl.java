package service.impl;

import service.Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OperationImpl implements Operation {
    ArrayList<Integer> list = new ArrayList<>();
    int max = 100;
    int min = 1;
    int range = max - min + 1;
    int maxN=0;
    int minN=100;
    @Override
    public void getMax() {
        for (int i = 0; i < 100; i++) {
            int rand = (int) (Math.random() * range);
            list.add(rand);
            if (rand > maxN) {
                maxN = rand;
            }
        }
        System.out.println("Max: " + maxN);
    }

    @Override
    public void getMin() {
        for (int i = 0; i < 100; i++) {
            int rand = (int) (Math.random() * range);
            list.add(rand);
            if (rand < minN) {
                minN = rand;
            }
        }
        System.out.println("Min: " + minN);
    }

    @Override
    public void getRepeat() {
        int maxRepl = 0;
        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            int replay = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    replay++;
                }
                if (replay >= maxRepl) {
                    maxRepl = replay;
                    num = list.get(i);
                }

            }
        }
        System.out.println("Replay number " + num );
    }

    @Override
    public void sortList() {
        Collections.sort(list);
        System.out.println("Sort " + list);
    }

    @Override
    public void get5() {
        int replay = 0;
        for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == 5) {
                    replay++;
                    
            }
        }
        System.out.println("Replay number 5: " + replay );
    }

    @Override
    public void get7() {
        int replay=0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)==7){
                replay++;
            }
        }
        System.out.println("Replay number 7 : "+replay);
    }

    @Override
    public void getRandomList() {
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * range);
            System.out.println(random);
        }
    }
}
