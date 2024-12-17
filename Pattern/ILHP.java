import java.util.Scanner;

public class ILHP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of Rows-");
        int rows = sc.nextInt();
        // for (int i = 1; i <= rows; i++) {
        //     for (int j = 1; j <= rows - i + 1; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        for(int i=rows;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
