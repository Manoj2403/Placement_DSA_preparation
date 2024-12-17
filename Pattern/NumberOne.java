public class NumberOne {
    public static void printPattern(int n){
        int i=1,j=1,k=1;
        for(i=1;i<=n;i++){
            for(j=i;j<=n;j++){
                System.out.print(j+" ");
            }
            for(k=1;k<i;k++){
                System.out.print(k +" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int n = 5;
        printPattern(n);
    }
}
