import java.util.*;

public class PathFindingMaze {
    public static boolean findPath(int[][] maze,int row,int col,boolean[][] vis){
        int[] delRow = {0,0,-1,1};
        int[] delCol = {-1,1,0,0};
        vis[row][col] = true;
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            return true;
        }
        for(int i=0;i<4;i++){
            int currRow = row + delRow[i];
            int currCol = col + delCol[i];
                // System.out.print(currRow + " " + currCol);
                // System.out.println();
            if(currRow>=0 && currCol>=0 && currRow<=maze.length-1 && currCol<=maze.length-1 && !vis[currRow][currCol] && maze[currRow][currCol]==0)
            {
                if(findPath(maze, currRow, currCol, vis))
                    return true;
            }
        }
        // if(row==maze.length-1 && col == maze.length-1)
        //     return true;
        // else
            return false;
    }
    public static void main(String[] args) {
        int[][] maze =  {
                            {0,1,0,0,0},
                            {0,1,0,1,0},
                            {0,1,0,1,0},
                            {0,1,0,1,0},
                            {0,0,0,1,0},
                        };
        if(maze[0][0]==1 || maze[maze.length-1][maze[0].length-1]==1){

            System.out.println("Path Does not Exists....Because starting point or end point is blocked..");
            return;
        }
        boolean[][] vis = new boolean[maze.length][maze.length];
        
        if(findPath(maze,0,0,vis))
            System.out.println("Path Exists...");
        else
            System.out.println("Path Does not Exists...");
                        
    }
}