public class SubMatrix {

    static int getSum(int r1,int r2,int c1,int c2,int dp[][]){
        return dp[r2][c2]-dp[r2][c1]-dp[r1][c2]+dp[r1][c1];
    }

    static void subMatSum(int grid[][],int k) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        int n = grid.length;
        int m = grid[0].length;

        // To initialize the subMatrix sum value in their places
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + grid[i][j];
            }
        }

        // Iterating to get the values(Sub Matrix sum) from dp array
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                System.out.print(dp[row][col] + " | ");
            }
            System.out.println();
        }
        int count=0;
        for (int i = 0; i < n+1-k ; i++) {
            for (int j = 0; j < m+1-k ; j++) {
                int sum = getSum(i, i + k, j, j + k, dp);
                if (sum == 99) {
                    System.out.println(i + " "+(i+k)+" " + j+" "+(j+k));
                }
                // System.out.print(++count+" ");
            }
        }
    }

    public static void main(String[] args) {
        int grid[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        subMatSum(grid,3);
    }
}
