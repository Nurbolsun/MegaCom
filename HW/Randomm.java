import java.util.Random;
import java.util.Scanner;
public class Randomm {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		int a = random.nextInt(9-2-1)+2;
		int b = random.nextInt(9-2-1)+2;
		int y = a*b;
		System.out.println("Ваш ответ ?");
		int c = scan.nextInt();
		boolean result = c == y;
		System.out.println("Ответ :" + result);
	}
}