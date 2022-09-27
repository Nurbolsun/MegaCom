import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int W = scan.nextInt();
        int H = scan.nextInt();
        int R = scan.nextInt();
        if (W+H ==R || W+R ==H || H+R==W){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}

