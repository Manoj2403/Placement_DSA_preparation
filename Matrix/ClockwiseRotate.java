import java.util.*;

public class ClockwiseRotate {
    public void rotateOuterEdges(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows < 2 || cols < 2) {
            return;
        }

        int temp[] = new int[4];
        temp[0] = matrix[0][0];
        temp[1] = matrix[0][cols-1];
        temp[2] = matrix[rows-1][cols-1];
        temp[3] = matrix[rows-1][0];
        //right traversal
        for(int col=cols-1;col>1;col--){
            matrix[0][col] = matrix[0][col-1];
        }
        //down traversal
        for(int row=rows-1;row>1;row--){
            matrix[row][cols-1] = matrix[row-1][cols-1];
        }
        //left traversal
        for(int col=0;col<cols-2;col++){
            matrix[rows-1][col] = matrix[rows-1][col+1];
        }
        //Up traversal
        for(int row=0;row<rows-2;row++){
            matrix[row][0] = matrix[row+1][0];
        }
        
        matrix[0][1] = temp[0];
        matrix[1][rows-1] = temp[1];
        matrix[rows-1][cols-2] = temp[2];
        matrix[rows-2][0] = temp[3];
        
    }

    public static void main(String[] args) {
        ClockwiseRotate sol = new ClockwiseRotate();
        int[][] matrix = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };
        
        sol.rotateOuterEdges(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
