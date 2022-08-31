import enitity.Day;
import enums.Weekend;

public class Main {
    public static void main(String[] args) {
        Day day = new Day(Weekend.HIDROGENIUM);
        day.getWeekend();

        switch (day.getWeekend()){
            case HIDROGENIUM:
                System.out.println("It is: 1\tВодород\tH\tHydrogenium");
            case HELIUM:
                System.out.println("It is: 2\tГелий\tHe\tHelium ");
            case LITHIUM:
                System.out.println("It is: 3\tЛитий\tLi\tLithium");
        }
    }
}