package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try {
            byte[] bytes = Files.readAllBytes(Paths.get("D:\\НУР\\GitHub\\SQL\\test.txt"));
            String text = new String(bytes, StandardCharsets.UTF_8);
            List<String> word = Arrays.asList(text.split("\\PL+ "));
            System.out.println(word.stream().filter(c -> c.length()>= 3).count());
        } catch (IOException e) {
            e.printStackTrace();
        }


//        List<User> users = new ArrayList<>(Arrays.asList(
//                new User(1l, 10000, 20, "aidai", Role.SELLER),
//                new User(2l, 15000, 25, "taalai", Role.SELLER),
//                new User(3l, 12000, 31, "aman", Role.OWNER),
//                new User(4l, 9000, 27, "saikal", Role.ADMIN),
//                new User(5l, 17000, 15, "dastan", Role.SELLER)
//        ));
//
//        users.stream().filter(c -> c.getAge() >24)
//                .filter(c-> c.getRole().equals(Role.SELLER))
//                .max(Comparator.comparing(User::getSalary));

//        users.stream()
//                .filter(user -> user.getRole().equals(Role.SELLER) && user.getAge() > 29)
//      //          .filter(user -> user.getAge() > 29)
//                .forEach(System.out::println);

//        users.stream().sorted(Comparator.comparing(User::getAge)).forEach(System.out::println);

//        Map<Role,List<User>> groupUser = users.stream().collect(Collectors.groupingBy(User::getRole));

//        Map<Double, List<User>> groupBySalary = users.stream()
//                .collect(Collectors.groupingBy(User::getSalary));
//        System.out.println(groupBySalary);

//        boolean result = users.stream()
//                .allMatch(c -> c.getAge()>18);
//        System.out.println(result);
//
//        boolean result = users.stream()
//                .noneMatch(c -> c.getAge()>18);
//        System.out.println(result);

//        long count = users.stream()
//                .filter(c -> c.getSalary() > 100)
//                .count();
//        System.out.println(count);

//        Map<String, String> map = new HashMap<>();
//        map.put("user", "aidai");
//        map.put("seller", "aibek");
//        map.put("admin", "atai");
//        map.put("user1", "meerim");
//
//        System.out.println(map.entrySet().stream().filter(c -> c.getValue().equals("aidai")).collect(Collectors.toList()));



    }
}
