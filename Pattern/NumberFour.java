// class NumberFour{
//     public static void printPattern(int n){
//         int place=1;
//         int start=1;
//         for(int i=1;i<=2*n;i++){    
//             if(i<=n){
//                 for(int space=1;space<=n-i;space++){
//                     System.out.print(" ");
//                 }
//                 int prevStart = start;
//                 for(int j=1;j<=i;j++){
//                     System.out.print(start--);
//                 }
//                 place++;
//                 start = prevStart+place;
//             }
//             else{
//                 for(int space=1;space<i-n;space++){
//                     System.out.print(" ");
//                 }
//                 int prevStart = start-place;
//                 start = prevStart;
//                 for(int j=i;j<=2*n;j++){
//                     System.out.print(start--);
//                 }
//                 start = prevStart;
//                 place--;
//             }
            
//             System.out.println();
//         }
//     }
//     public static void main(String[] args) {
//         int row=4;
//         printPattern(row);
//     }
// }
/*
 *     1
 *    32
 *   654
 * 10987
 * 10987
 *   654
 *    32
 *     1
 */

 class NumberFour{
    public static void printPattern(int n){
        int start=1;
        int k=1;
        for(int i=1;i<=2*n;i++){    
            if(i<=n){
                start = (i*(i+1))/2;
                for(int space=1;space<=n-i;space++){
                    System.out.print(" ");
                }
                for(int j=1;j<=i;j++){
                    System.out.printf("%d", start--);
                }
                k=i;
            }
            else{
                start = (k*(k+1))/2;
                for(int space=1;space<i-n;space++){
                    System.out.print(" ");
                }
                for(int j=i;j<=2*n;j++){
                    System.out.printf("%d", start--);
                }
                k--;
            }
            
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int row=4;
        printPattern(row);
    }
}