import java.util.*;
public class Pascal {
    static long nCr(int n,int r){
        long res = 1;
        for(int i=1;i<=r;i++){
            res = (res*(n-i+1))/i;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int line=sc.nextInt();
            for(int n=1;n<=line;n++){
                for(int space=1;space<=line-n;space++){
                    System.out.print(" ");
                }
                for(int r=1;r<=n;r++){
                    System.out.print(nCr(n-1,r-1) +" ");
                }
                System.out.println();
            }
        }
    }
}
