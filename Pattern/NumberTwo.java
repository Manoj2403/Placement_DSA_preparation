public class NumberTwo {
    public static void printPattern(int n){
        int i=1,j=1;
        for(i=1;i<=n;i++){
            for(int space=1;space<=n-i;space++){
                System.out.print(" ");
            }
            for(j=i;j>=1;j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }
}
