import java.util.Scanner;
public class Annuit {
	public static void main(String[] args) {
		// a=k*(p/(1+p)-m-1)
		Scanner scan = new Scanner(System.in);
		System.out.print("Формула расчета аннуитетного платежа : ");
		System.out.printf("%n");
		System.out.print("Сумма кредита :");
		int k = scan.nextInt();
		System.out.print("Процентная ставка :");
		float p = scan.nextFloat();
		System.out.print("Количество месяцев :");
		int m = scan.nextInt();
		float x ;
		x = p % 100;
		double a = k*(x/(1+x)-m-1);
		System.out.println("Ваш ответ : " + a);

		// int a = 50;
		// double b = 7;
		// double c;
		// c = a * b / 100; 
		
		// System.out.println(c);
	}
}