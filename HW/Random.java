import java.util.Scanner;
import java.util.Random;
public class Random {
	public static void main(String[] args) {
		Random rnd = new Random();
		int a = rnd.nextInt (9 - 1 + 1) + 1;
		System.out.println(a);
	}
}