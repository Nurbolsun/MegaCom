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
//        Scanner scanner = new Scanner(System.in);
//
//        String dateSc1 = scanner.next();
//        String dateSc2 = scanner.next();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        long time;
//
//        try {
//            Date dt = dateFormat.parse(dateSc1);
//            Date dt2 = dateFormat.parse(dateSc2);
//            long result = Math.abs(dt2.getTime() - dt.getTime());
//            long convert = TimeUnit.DAYS.convert(result, TimeUnit.MILLISECONDS);
//            System.out.println(convert);
//        } catch (Exception e) {
//            throw new RuntimeException("¬ведите правильно");
//        }
        //Class
        String start_date = "09/24/2021";
        String end_date = "10/17/2021";
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date date1 = format.parse(start_date);
        Date date2 = format.parse(end_date);
        int days =(int) ((date1.getTime() - date2.getTime())/1000/60/60/24);
        System.out.println(days);
    }
}