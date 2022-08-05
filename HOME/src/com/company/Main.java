
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Выберите : +, -, *, /");
        char math = scan.next().charAt(0);
        System.out.println("Введите первое число");
        double num1 = scan.nextDouble();
        System.out.println("Введите второе число");
        double num2 = scan.nextDouble();
        switch(math) {
            case '+':
                System.out.println(num1 + num2);
                break;
            case '-':
                System.out.println(num1 - num2);
                break;
            case '*':
                System.out.println(num1 * num2);
                break;
            case '/':
                System.out.println(num1 / num2);
                break;
            default:
                System.out.println("Hello");
        }
    }
}
