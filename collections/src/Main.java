import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        String[] strings = new String[3];
//        strings[0] = "Aidai";
//        System.out.println(Arrays.toString(strings));
//        ArrayList <String> list = new ArrayList<>();
//        list.add("Dastan");
//        System.out.println(list);
//        ArrayList arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
//        System.out.println(Collections.max(arrayList));
//        System.out.println(Collections.min(arrayList));

        Operation operation = new OperationImpl();

        operation.getInfoAge();
    }
}