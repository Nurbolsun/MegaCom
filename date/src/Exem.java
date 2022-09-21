import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Exem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exemDay = "18.04.2022";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Введите дату в таком формате: dd.MM.yyyy");
        String date = scanner.next();
        try {
            Date dateExem = dateFormat.parse(exemDay);
            Date scanDay = dateFormat.parse(date);
            long convExem = dateExem.getTime();
            long convScan = scanDay.getTime();
            if (convScan == convExem){
                System.out.println("Экзамен сегодня!");
            }else if (convScan < convExem){
                long result = Math.abs(convExem - convScan);
                long convert = TimeUnit.DAYS.convert(result, TimeUnit.MILLISECONDS);
                System.out.println("До экзамена осталось " + convert + " дней");
            }else if (convScan > convExem){
                long result = Math.abs(convScan - convExem);
                long convert = TimeUnit.DAYS.convert(result, TimeUnit.MILLISECONDS);
                System.out.println("Экзамен был " + convert + " дней назад");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
