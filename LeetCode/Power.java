import java.util.*;
class Power{
    public static double myPow(double x,int n){
        if(n==0)
            return 1;
        return x*myPow(x,n-1);
    }
    public static void main(String[] args) {
        
        System.out.println(myPow(2,Integer.parseInt(args[0]))); //pass the number at run time by command lnie arguments i.e(java Power 10)
    }
}