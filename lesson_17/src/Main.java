import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello world!");
        int [] nums = new int[10];
        int i;
        for (int i = 0; i <nums.length ; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println("str");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}