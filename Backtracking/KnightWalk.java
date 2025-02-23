import java.util.*;

//Zoho Asked Question
class Cell{
    int row;
    int col;
    int distance;
    Cell(int row,int col,int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
public class KnightWalk
{
    private static int N;
    private static int targetX;
    private static int targetY;
    public static boolean isValid(int x,int y,boolean[][] visited){
        return x>=0 && x<N && y>=0 && y<N  && !visited[x][y];
    }
    public static int bfs(int x,int y){
        Queue<Cell> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(new Cell(x,y,0));
        visited[x][y] = true;
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
        while(!q.isEmpty()){
            Cell currCell = q.poll();
            int currRow = currCell.row;
            int currCol = currCell.col;
            int distance = currCell.distance;
            if(currRow==targetX && currCol==targetY)    
                return distance;
            for(int i=0;i<8;i++){
                int nRow=currRow+dx[i];
                int nCol=currCol+dy[i];
                if(isValid(nRow,nCol,visited)){
                    visited[nRow][nCol] = true;
                    q.offer(new Cell(nRow,nCol,distance+1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        N = 8;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Soruce Row Number : (1 based Indexing)");
        int srcY = sc.nextInt();
        System.out.println("Enter the Source Column Number : (1 based Indexing)");
        int srcX = sc.nextInt();
        System.out.println("Enter the Target Row Number : (1 based Indexing)");
        targetX = sc.nextInt()-1;
        System.out.println("Enter the Target Column Number : (1 based Indexing)");
        targetY = sc.nextInt()-1;
        System.out.println("Minimum Moves to reach target from "+srcX +" "+srcY+" is "+bfs(srcX-1,srcY-1));

    }
}