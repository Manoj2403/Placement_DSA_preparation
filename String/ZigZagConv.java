import java.util.*;

class ZigZagConv {
    public static void convert(String s, int n) {
        if(n==1){
            System.out.println(s);
            return ;
        }
        for (int j = 0; j < n; j++) {
            int jump = j;
            int jump1 = (n - (j + 1)) + (n - (j + 1));// Index jumping Calculation
            int jump2 = ((j + 1) - 1) + ((j + 1) - 1);// Index jumping Calculation...Here (j+1) took because O based
                                                      // indexing are taken for calculation
            System.out.print(s.charAt(jump) + " ");
            while (jump < s.length()) {
                jump += jump1;
                // System.out.println("Top of while loop:"+jump);
                if (jump < s.length()) {
                    if (jump1 != 0 && jump < s.length())
                        System.out.print(s.charAt(jump) + " ");
                    jump += jump2;
                    if (jump2 != 0 && jump < s.length()) {
                        System.out.print(s.charAt(jump) + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        // int numRows = 10;
        Scanner sc = new Scanner(System.in);
        while (true) {
            int numRows = sc.nextInt();
            if (numRows > s.length())
                break;
            convert(s, numRows);
            System.out.println("---------");
        }
        sc.close();
    }
}