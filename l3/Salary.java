import java.util.Scanner;

public class Salary {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Оклад :");
		int o = scan.nextInt();

		System.out.print("Календарь :");
		int dc = scan.nextInt();

		System.out.print("Отработанных дней :");
		int df = scan.nextInt();

		System.out.print("Премия :");
		int p = scan.nextInt();

		
		final double N = 100%13;

		System.out.print("Рзличные удержания :");
		int y = scan.nextInt();

		double s = o/dc*df+p-N-y;

		System.out.println("Ваша зарплата составляет : " + s);
		}
}