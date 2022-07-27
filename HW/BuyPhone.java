import java.util.Scanner;

public class BuyPhone {
	public static void main(String[] args) {
	Scanner scan = new Scanner (System.in);
		System.out.print("Стоимость телеона 50 000 !");
		System.out.printf("%n");
		final int phone = 50000;
		int pocket = 10;
		System.out.print("Сколько денег у вас есть в кармане ?");
		int money = scan.nextInt();
		boolean result = money - phone >= pocket ; 

		if ( result == true) {
		System.out.println("Да, вы можете купить!");
		}
		else {
		System.out.println("К сожалению вы не можете купить!");
		}
		/*System.out.println(result);*/
		}
}