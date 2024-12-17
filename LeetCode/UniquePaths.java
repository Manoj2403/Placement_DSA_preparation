class UniquePaths {
    public int findUniquePaths(int[][] grid,int row,int col){
        if(row==grid.length-1 && col==grid[0].length-1)
            return 1;
        if(row>=grid.length || col>=grid[0].length)
            return 0;
        else return findUniquePaths(grid, row+1, col) + findUniquePaths(grid, row, col + 1);

    }

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        return findUniquePaths(grid, 0, 0);
    }
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(1, 1));
    }
}