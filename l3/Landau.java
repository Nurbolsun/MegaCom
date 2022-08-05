import java.util.Scanner;
public class Landau {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.print("Обхват по бюсту: ");
		int k = scan.nextInt();

		System.out.print("По бедрам: ");
		int m = scan.nextInt();

		System.out.print("По талии: ");
		int n = scan.nextInt();

		System.out.print("Рост: ");
		double t = scan.nextDouble();

		System.out.print("Вес: ");
		int p = scan.nextInt();

		double l = (k*m*t)/((n*n)*p);

		System.out.println(l);
	} 
}