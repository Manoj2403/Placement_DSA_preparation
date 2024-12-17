import java.util.*;
public class Hollow_Triangle {
    public static void main(String[] args) {
        // -------------------------Hollow Triangle-------------------------
        int rows=5;
        for(int i=1;i<=rows;i++){
            for(int space=1;space<=rows-i;space++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i-1);j++){
                if(j==1||i==rows||j==(2*i-1))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        //-------------------------Inverse Hollow Triangle-------------------------
        // int rows=5;
        // for(int i=rows;i>=0;i--){
        //     for(int space=i;space<rows;space++){
        //         System.out.print(" ");
        //     }
        //     for(int j=1;j<=(2*i-1);j++){
        //         if(j==1||i==rows||j==(2*i-1))
        //             System.out.print("*");
        //         else
        //             System.out.print(" ");
        //     }
        //     System.out.println();
        // }
        System.out.println(Long.MIN_VALUE);
    }
}
