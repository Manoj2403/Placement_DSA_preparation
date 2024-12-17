public class IslandPerimeter {
    private static int findPerimeter(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    perimeter += 4;
                    // System.out.println("R-"+row+"col-"+col+" "+perimeter);
                    if ((row >= 0 && col - 1 >= 0) && grid[row][col - 1] == 1)
                        perimeter -= 2;
                    if ((row - 1 >= 0 && col >= 0) && grid[row - 1][col] == 1)
                        perimeter -= 2;
                    // System.out.println("R-"+row+"col-"+col+" "+perimeter);
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        // int grid[][] = {
        //         { 1, 1, 1, 1 },
        //         { 1, 1, 1, 1 },
        //         { 1, 1, 0, 1 },
        //         { 1, 1, 1, 1 }
        // };
        int grid[][] = {
                { 0, 1, 0, 0 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 1, 0, 0 }
        };
        System.out.println(findPerimeter(grid));
    }
}
