	import java.util.Scanner;
public class Bus {
	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        short busNum = 304;
        short trolleybusNum = 9;
        byte busPrice = 15;
        byte trolleybusPrice = 11;
        short peopleInBus = 30;
        short peopleInTrolleybus = 50;

        System.out.println("Сколько у вас денег? ");
        int myMoney = scanner.nextInt();

        System.out.println("Какой автобус приехал? ");
        int bus = scanner.nextInt();
        System.out.println("Сколько людей в автобусе? ");
        int peopleCameBus = scanner.nextInt();

        System.out.println("Какой троллейбус приехал? ");
        int trolleybus = scanner.nextInt();
        System.out.println("Сколько людей в троллейбусе? ");
        int peopleCameTrolleybus = scanner.nextInt();

        String result = (myMoney >= busPrice || myMoney >= trolleybusPrice) && (bus == busNum || trolleybus == trolleybusNum) && 
        (peopleCameBus < peopleInBus || peopleCameTrolleybus < peopleInTrolleybus) ? "Go" : "Stay" ;
		
		System.out.println(result);
	}
}