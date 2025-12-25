import java.util.*;

class Pair {
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class MazeRunner {
    private static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, 1 },
            { 1, -1 } };

    public static int findShortestDistance(char[][] maze, int row, int col, boolean[][] visited, int n) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col, 0));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int currRow = pair.row;
            int currCol = pair.col;
            int currDist = pair.dist;
            if (maze[currRow][currCol] == 'D') {
                return currDist;
            }
            visited[currRow][currCol] = true;
            for (int[] dir : directions) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol]) {
                    q.offer(new Pair(nextRow, nextCol, currDist + 1));
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of rows for Maze : ");
        int noOfrows = sc.nextInt();
        char[][] maze = new char[noOfrows][noOfrows];
        boolean[][] visited = new boolean[noOfrows][noOfrows];
        for (int i = 0; i < noOfrows; i++) {
            for (int j = 0; j < noOfrows; j++) {
                maze[i][j]='0';
            }
        }
        System.out.println("Enter Adventurer Postion(Row Postion)");
        int adventurer_row_position = sc.nextInt();
        System.out.println("Enter Adventurer Postion(Column Postion)");
        int adventurer_col_position = sc.nextInt();
        maze[adventurer_row_position][adventurer_col_position] = 'A';

        System.out.println("Enter Destination Postion(Row Postion)");
        int destination_row_position = sc.nextInt();
        System.out.println("Enter Destination Postion(Column Postion)");
        int destination_col_position = sc.nextInt();
        maze[destination_row_position][destination_col_position] = 'D';

        System.out.println("-----------------------");
        for (int i = 0; i < noOfrows; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < noOfrows; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        int minDistance = findShortestDistance(maze, adventurer_row_position, adventurer_col_position, visited,
                noOfrows);
        System.out.println("The Shortest Distance is : " + minDistance);

        sc.close();
    }
}

// We can Solve this by using DFS but using BFS is optimized one because here we need to calculate Shortest Distance
