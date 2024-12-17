import java.util.Scanner;

public class RHP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of Rows-");
        int rows = sc.nextInt();
        for (int i = 1; i <= rows; i++) {
            for(int space = 1;space<=rows-i;space++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
