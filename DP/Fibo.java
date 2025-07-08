// package DP;
import java.util.*;
public class Fibo {
    public static long fib(int n,long[] dp){
        if(n==0 || n==1)
            return n;
        if(dp[n]!=0)
            return dp[n];
        return dp[n] = fib(n-2,dp) + fib(n-1,dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Int can handle small inputs
        // int n = sc.nextInt();
        // int[] dp = new int[n+1];

        //Long can Handle larged inputs (Like n=100 above)
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        System.out.println(fib(n,dp));
    }
}   
