public class NumberThree {
    public static void printPattern(int n){
        int i=1,j=1;
        int prevStart=2,start=1;
        for(i=1;i<=n;i++){
            for(int space=1;space<=n-i;space++){
                System.out.print(" ");
            }
            int currStart=start;
            for(j=1;j<=i;j++){
                System.out.print(start);
                start+=2;
            }
            //here (start-2 )depicts the end position
            start = ((start-2)-currStart)+prevStart;
            prevStart = currStart;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int row = 4;
        printPattern(row);
    }
}

/*
 *                 1
 *              2  4
 *           3  5  7
 *        6  8 10 12        | |  | 
 *     9 11 13 15 17----->(12-6)+3=9(start)
 * 14 16 18 20 22 24
 */