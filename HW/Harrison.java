import java.util.Scanner;

public class Harrison {
	public static void main(String[] args) {
	Scanner scan = new Scanner (System.in);
		 System.out.print("Для женщин :");
		 System.out.printf("%n");
		 System.out.print("Вес :");
		 float wkg = scan.nextFloat();
		 System.out.print("Рост :");
		 float wh = scan.nextFloat();
		 System.out.print("Возраст :");
		 int wa = scan.nextInt();
		 double result = 655.1+(13.75*wkg)+(1.85*wh)-(4.676*wa);
		 System.out.print("Cколько ккал необходимо употреблять для поддержания веса :");
		 System.out.printf("%n");
		 System.out.print("Минимальный - 1,2 | Низкий - 1,375 | Умеренный - 1,55 | Высокий - 1,7 | Экстремальный - 1,9 :  /n  Выберите цифры :");
		 float kkal = scan.nextFloat();		 
		 System.out.println("Ваш ответ : " + result*kkal);
	}
}