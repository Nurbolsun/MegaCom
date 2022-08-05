import java.util.Scanner;
public class Bus {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		short busNum = 304;
		short trolleybusNum = 9;
		byte busPrice = 15;
		byte trolleybusPrice = 11;
		byte peopleInBus = 30;
		byte peopleInTrolleybus = 50;

		System.out.println("Сколько у вас денег? ");
		int myMoney = scan.nextInt();

		System.out.println("Какой автобус приехал ?");
		int bus = scan.nextInt();
		System.out.println("Сколько людей в автобусе ?");
		int peopleCameBus = scan.nextInt();

		System.out.println("Какой троллейбус приехал ?");
		int trolleybus = scan.nextInt();
		System.out.println("Сколько людей в троллейбусе ?");
		int peopleCameTrolleybus = scan.nextInt();

		String result = (myMoney >= busPrice || myMoney >= trolleybusPrice) && (bus == busNum || trolleybus == trolleybusNum) && 
		(peopleCameBus < peopleInBus || peopleCameTrolleybus < peopleInTrolleybus ) ? "Go" : "Stay"; 
		
		System.out.println(result);
	}		

}