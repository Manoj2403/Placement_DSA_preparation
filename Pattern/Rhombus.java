public class Rhombus {
    public static void main(String[] args) {

        // -----------------Rhombus-----------------------
        // int rows=4;
        // for(int i=0;i<rows;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print(" ");
        //     }
        //     for(int k=0;k<rows;k++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        //---------------------Reversed Rhombus--------------
        int rows=5;
        for(int i=0;i<rows;i++){
            for(int space=0;space<rows-i;space++){
                System.out.print(" ");
            }
            for(int j=1;j<=rows;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
