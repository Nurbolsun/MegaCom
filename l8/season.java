import java.util.Random;
import java.util.Scanner;

public class season {
	public static void main(String[] args) {
		
		// int seasonNum = 2;

		// switch (seasonNum) {
		// case 1 , 2 , 13 :
		// 	System.out.println("Winter");
		// }

		// for (int i = 0; i<5 ;i++ ) {
		// 	System.out.println("I am Nurbolsun");
		// 	System.out.println(i);
		// }

		// int a = 0;
		// while (a<10) {
		// 	a++;
		// 	System.out.println(a);
		// }

		Random random = new Random();
		Scanner scan = new Scanner(System.in);

		 int num = random.nextInt(100-0+1)+0;
		 int n =10;

		 // for (int i = 0;i < 10 ;i++ ) {
		 // 	System.out.println("Ваше предположение: ");
		 	
		 // 	int b = n--;
		 // 	System.out.println("У вас осталось попыток" + --b );
		 // 	int userNum = scan.nextInt();
		 // 	if (userNum == num) {
		 // 		System.out.println("Вы отгадали");
		 // 		break;		 		
		 // 	} else {
		 // 		if (num > userNum) {
		 // 			System.out.println("Ваша цифра меньше");
		 // 		} else {
		 // 			System.out.println("Ваша цифра больше");
		 // 		}
		 // 	}
		 // }

		 int i = 0;
		 while (i<10) {
		 	i++;
		 	System.out.println("Ваше предположение: ");
		 	
		 	int b = n--;
		 	System.out.println("У вас осталось попыток" + --b );
		 	int userNum = scan.nextInt();
		 	if (userNum == num) {
		 		System.out.println("Вы отгадали");
		 		break;		 		
		 	} else {
		 		if (num > userNum) {
		 			System.out.println("Ваша цифра меньше");
		 		} else {
		 			System.out.println("Ваша цифра больше");
		 		}
		 	}
		
		 if (userNum == num) {
		 	System.out.println("Вы не отгадали, задуманное цисло " + num);
		 }
		 } 
	}
}