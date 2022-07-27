import java.util.Scanner;
public class TwoNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите первое число :");
		int a = scan.nextInt();
		System.out.print("Введите второе число :");
		int b = scan.nextInt();
		boolean result = a % b == 0;
		System.out.println(result);
	}
}