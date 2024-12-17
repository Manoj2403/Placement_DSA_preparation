import java.util.*;
public class LCS{
    static String str1 = "bd";
    static String str2 = "abcd";
    public static int lcs(int i,int j,int[][] dp){
        if(i==str1.length() || j==str2.length())
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        char c1 = str1.charAt(i);
        char c2 = str2.charAt(j);
        if(c1==c2){
            return dp[i][j] = 1+lcs(i+1,j+1,dp);
        }
        else
        {
            return dp[i][j]=Math.max(lcs(i+1,j,dp),lcs(i,j+1,dp));
        }
    }
    public static void main(String[] args) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(lcs(0,0,dp));


        //Bottom up apporach-------------------
        // int m = str1.length();
        // int n = str2.length();
        // int[][] dp = new int[m+1][n+1];
        // for(int i=1;i<=m;i++){
        //     for(int j=1;j<=n;j++){
        //         char c1 = str1.charAt(i-1);
        //         char c2 = str2.charAt(j-1);
        //         if(c1==c2){
        //             dp[i][j] = 1+dp[i-1][j-1];
        //         }
        //         else{
        //             dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        //         }
        //     }
        // }
        // System.out.println(dp[m][n]);
    }
}