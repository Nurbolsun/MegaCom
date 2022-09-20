import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String date = "4 12 2020";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
        try {
            Date date1 = dateFormat.parse(date);
            System.out.println(date1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}