import service.MyInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("BMW", "Toyota", "Mazda", "Lexus", "Opel", "Audi");

        MyInterface myInterface = () -> {
            return Math.random();
        };
        list.forEach(n-> {
            System.out.println(n + " " + myInterface.createRandom());
        });

    }
}