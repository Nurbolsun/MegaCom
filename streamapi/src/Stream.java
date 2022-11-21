import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("BMW", "Toyota", "Mazda", "Lexus", "Opel", "Audi", "Honda");

        List<String> first = list.stream().filter(n -> n.length()<=3).map(n-> n + "Hi").filter(n -> n.equals("OpelHi")).collect(Collectors.toList());
        first.stream().forEach(System.out::println);
        System.out.println(first);

        List<Integer> price = Arrays.asList(100,200,300,400,500,600,700,1000);
        List<Integer> price2 = price.stream().map(n-> {
            return n = n + (n * 10 / 100);
        }).collect(Collectors.toList());
        price2.forEach(System.out::println);
    }
}
