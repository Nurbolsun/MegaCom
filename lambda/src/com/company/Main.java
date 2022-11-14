package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	MyInterface myInterface = (int a) -> {
        System.out.println("Hello ");
        return a* 15;
    };
        System.out.println(myInterface.getValue(5));

        List<Integer> myList = Arrays.asList(1,2,3,4,5);
        myList.forEach((n) ->System.out.println("Lambda "+ n));

//        for (Integer x: myList) {
//            System.out.println("Regular"x);
//        }

    }
}
