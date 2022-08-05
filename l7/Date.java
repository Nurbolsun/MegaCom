import java.util.Scanner;
public class Date {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Введите число");

		int number = scan.nextInt();

		int a = number/100;
		int b = number/10%10;
		int c = number%10;
		int result;

		if (number%2==0) {
				result = a+b+c;
		}else {
			
				result = a*b*c;

		// if (month == 12 || month == 1 || month == 2) {
		// 	System.out.println("Winter");
		// 	}
		// 	else if (month == 3 || month == 4 || month == 5) {
		// 		System.out.println("Spring");	
		// }
		// else if (month == 6 || month == 7 || month == 8) {
		// 		System.out.println("Summer");	
		}

		System.out.println(result);

		// int month = scan.nextInt();
		// }
		// else if (month == 9 || month == 10 || month == 11) {
		// 		System.out.println("Autumn");	
		// }

		// switch (month) {
		// 	case 1:
		// 		System.out.println("Winter");
		// 		break;
		// 	case 2:
		// 		System.out.println("Winter");
		// 		break;
		// 	case 3:
		// 		System.out.println("Spring");
		// 		break;
		// }


	}
}