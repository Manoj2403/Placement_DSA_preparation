public class SubMatProblems {
    public static void build(int[][] grid ,int[][] prefixGrid){
        for(int i=1;i<prefixGrid.length;i++){
            for(int j=1;j<prefixGrid[0].length;j++){
                prefixGrid[i][j] = prefixGrid[i-1][j]+prefixGrid[i][j-1]-prefixGrid[i-1][j-1]+1;
            }
        }
    }

    public static int sumGrid(int[][] prefixGrid){
        int sum = 0;
        for(int i=1;i<prefixGrid.length;i++){
            for(int j=1;j<prefixGrid[0].length;j++){
                sum+=prefixGrid[i][j];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int grid[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] prefixGrid = new int[m+1][n+1];
        build(grid,prefixGrid);
        int sum = sumGrid(prefixGrid);
        System.out.println("Number of SubMatrices by using PrefixSum Method : "+sum);


        //By using Formula
        int rowCombinations = m*(m+1)/2;
        int colCombinations = n*(n+1)/2;
        System.out.println("Number of SubMatrices by using Formula : "+rowCombinations * colCombinations);
    }
}
