package org.example;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        try {
//            byte[] bytes = Files.readAllBytes(Paths.get("\"C:\\Users\\MRX\\Downloads\\wiki.txt\""));
//            Str
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Path path = Path.of("src", "")
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        StringBuilder newStr = new StringBuilder(str);
        newStr.deleteCharAt(n);
        System.out.println(newStr);
    }
}