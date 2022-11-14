package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("Apple");
        deque.addFirst("Orange");
        deque.addLast("Pineapple");
        deque.add("Lemon");

//        deque.removeFirst();
//        deque.removeLast();
        System.out.println(deque.pop());
        System.out.println(deque);
    }
}
