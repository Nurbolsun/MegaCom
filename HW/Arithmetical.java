import java.util.Scanner;
 public class Arithmetical {
 	public static void main(String[] args) {
 		Scanner scan = new Scanner(System.in);
 		System.out.print("Вывести на экран среднее арифметическое!\n");
 		System.out.print("Введите первое число :");
 		int num1 = scan.nextInt();
 		System.out.print("Введите второе число :");
 		int num2 = scan.nextInt();
 		System.out.print("Введите третье число :");
 		int num3 = scan.nextInt();
 		System.out.print("Введите четвертое число :");
 		int num4 = scan.nextInt();
 		float summ = (num1 + num2 + num3 +num4) / 4f;
 		System.out.println("Сумма : " +summ);
 	}
 }