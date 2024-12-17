import java.util.Scanner;

public class Islands {
    static int sum = 0;

    public static void dfs(int[][] grid, int row, int col, boolean[][] vis) {
        int[] delRow = { -1, 1, 0, 0 };
        int[] delCol = { 0, 0, -1, 1 };
        vis[row][col] = true;
        for (int i = 0; i < 4; i++) {
            //for Every recursion row value will be changed and it leads to logical error
            //row = row + delRow[i]
            //col = col + delCol[i]; ------->Dont use like this
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && !vis[nRow][nCol]
                    && grid[nRow][nCol] == 1) {
                dfs(grid, nRow, nCol, vis);
            }
        }
    }

    public static int numIslands(int[][] grid, int n, int m) {
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                    dfs(grid, i, j, vis);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Rows:");
        int n = sc.nextInt();
        System.out.println("Enter no of Columns:");
        int m = sc.nextInt();
        System.out.println("Enter the ("+n+"*"+m+") Values(0's and 1's)");
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = sc.nextInt();
                if(val>=0 && val<=1){
                    grid[i][j] = val;
                }
                else   
                {
                    System.out.println("Number should be in the range of 0 and 1");
                    return;
                }
            }
        }
        System.out.println("Number of Islands : " + numIslands(grid, n, m));
    }
}
