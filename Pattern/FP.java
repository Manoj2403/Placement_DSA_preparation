import java.util.Scanner;

public class FP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of Rows-");
        int rows = sc.nextInt();
        //Full pyramid with odd number of stars in each rows
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
                //     *
                //    ***
                //   *****
                //  *******
                // *********

        /*
         * Full Pyramid as like as Right Half pyramid with space before or after *(i.e
         * '*' / '* ')
         */
        // int k = 1;
        // for ( k = 1; k <= 2 * rows - 1; k++) {
        //     System.out.print("| ");
        // }
        System.err.println();
        for (int i = 1; i <= rows; i++) {
            for (int space = 1; space <= rows - i; space++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print(" *");
            System.out.println();
        }   

    //      *
    //     * *
    //    * * *
    //   * * * *
    //  * * * * *


        
    }
}
