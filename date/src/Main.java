import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String dateSc1 = scanner.next();
        String dateSc2 = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        long time;

        try {
            Date dt = dateFormat.parse(dateSc1);
            Date dt2 = dateFormat.parse(dateSc2);
            long result = Math.abs(dt2.getTime() - dt.getTime());
            long convert = TimeUnit.DAYS.convert(result, TimeUnit.MILLISECONDS);
            System.out.println(convert);
        } catch (Exception e) {
            throw new RuntimeException("¬ведите правильно");
        }
    }
}