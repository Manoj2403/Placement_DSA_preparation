public class RatInMaze {
    static void func(int[][] maze,int row,int col,boolean[][] vis,String str){
        if(row==maze.length-1 && col == maze[0].length-1){
            System.out.println(str);
            return ;
        }
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};
        char[] dir = {'U','R','D','L'};
        vis[row][col] = true;
        for(int i=0;i<4;i++){
            int nRow = dRow[i]+row;
            int nCol = dCol[i]+col;
            if(nRow>=0 && nCol>=0 && nRow<maze.length && nCol<maze[0].length && maze[nRow][nCol]==1 && !vis[nRow][nCol]){
                // str = ;
                func(maze,nRow,nCol,vis,str+" "+dir[i]);
            }
        }
        vis[row][col]=false;
    }
    public static void main(String[] args) {
        int[][] maze = {
                    {1,1,1,1,1},
                    {1,0,1,1,0},
                    {1,0,1,0,1},
                    {1,1,0,0,1},
                    {0,1,1,1,1}
                    };
        int n = maze.length;
        if(maze[0][0]==0 || maze[n-1][n-1]==0){
            System.out.println("No Path Exist");
            return ;
        }
        boolean[][] vis = new boolean[n][n];
        func(maze,0,0,vis,"");
    }
}
