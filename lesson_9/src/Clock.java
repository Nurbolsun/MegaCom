import java.util.Scanner;

public class Clock {
    public static void main(String[] args) {
        int hour;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число: ");
        hour = scan.nextInt();
        System.out.println(season(hour));
    }
    static String season (int hour) {
        switch (hour) {
            case 6 - 12:
                return "Morning";
            case 13 - 17:
                return "Day";
            case 18 - 20:
                return "Evening";
            case 21 - 24, 1, 2, 3, 4, 5:
                return "Night";
        }
            return "Error";
    }
}
