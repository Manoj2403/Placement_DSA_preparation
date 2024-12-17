
public class Spiral {

    public void spiralOrder(int[][] matrix,int n) {
        // Initialize the bounds for the rows and columns
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        int count = n; // Counter to fill the matrix

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse right
            
            for (int right = colBegin; right <= colEnd; right++) {
                matrix[rowBegin][right] = count;
                // System.out.print(matrix[rowBegin][right] + " ");
            }
            rowBegin++;

            // Traverse down
            if (colBegin <= colEnd) { // Check necessary to avoid double printing when narrowing to a single column
                for (int down = rowBegin; down <= rowEnd; down++) {
                    matrix[down][colEnd] = count;
                    // System.out.print(matrix[down][colEnd] + " ");
                }
                colEnd--;
            }

            // Traverse left
            if (rowBegin <= rowEnd) { // Check necessary to avoid double printing when narrowing to a single row
                for (int left = colEnd; left >= colBegin; left--) {
                    matrix[rowEnd][left] = count;
                    // System.out.print(matrix[rowEnd][left] + " ");
                }
                rowEnd--;
            }

            // Traverse up
            if (colBegin <= colEnd) { // Similarly avoid double printing in narrow columns
                for (int up = rowEnd; up >= rowBegin; up--) {
                    matrix[up][colBegin] = count;
                    // System.out.print(matrix[up][colBegin] + " ");
                }
                colBegin++;
            }
            count--;
        }
    }

    public static void main(String[] args) {
        Spiral sol = new Spiral();
        int n = 3;
        int[][] matrix = new int[2*n-1][2*n-1];
        sol.spiralOrder(matrix,n);
        
        // Optionally, to display the final matrix state
        System.out.println("Final matrix in spiral order:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}
