import java.util.*;

public class Djikstra {
    static int minDistance(int[] dist, boolean[] vis, int V) {
        int min = Integer.MAX_VALUE;
        int min_idx = -1;
        for (int i = 0; i < V; i++) {
            if (!vis[i] && dist[i] <= min) {
                min = dist[i];
                min_idx = i;
            }
        }
        return min_idx;
    }

    static void printSolution(int[] dist, int[] prevNode, int V) {
        System.out.println("Vertex\t\tDistance\tPrevNode");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i] + "\t\t" + prevNode[i]);
        }
    }

    static void findShortestPath(int[][] graph, int src, int V) {
        System.out.println("Distance From Vertex "+src);
        int[] dist = new int[V];
        boolean[] vis = new boolean[V];
        int[] prevNode = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            vis[i] = false;
        }
        dist[src] = 0;
        // prevNode[src]=0;
        for (int count = 0; count < V; count++) {
            int u = minDistance(dist, vis, V);
            vis[u] = true;
            for (int v = 0; v < V; v++) {
                if (!vis[v] && graph[u][v] != 0) {
                    int cost = dist[u] + graph[u][v];
                    // dist[v] = Math.min(dist[v], cost);
                    if(cost<dist[v]){
                        dist[v] = cost;
                        prevNode[v] = u;
                    }
                }
            }
        }
        printSolution(dist,prevNode, V);
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 1, 4, 0, 0, 0 },
                { 1, 0, 4, 2, 7, 0 },
                { 4, 4, 0, 3, 5, 0 },
                { 0, 2, 3, 0, 4, 6 },
                { 0, 7, 5, 4, 0, 7 },
                { 0, 0, 0, 6, 7, 0 }
        };
        // int[][] graph = {
        //                     {0,2,6,0,0,0,0},
        //                     {2,0,0,5,0,0,0},
        //                     {6,0,0,8,0,0,0},
        //                     {0,5,8,0,10,15,0},
        //                     {0,0,0,10,0,0,2},
        //                     {0,0,0,15,0,0,6},
        //                     {0,0,0,0,0,2,6,0}
        //                 };
        // int[][] graph = {
        //     // 0  1  2  3  4  5  6
        //     { 0, 2, 6, 0, 0, 0, 0 }, // Node 0
        //     { 2, 0, 0, 5, 0, 0, 0 }, // Node 1
        //     { 6, 0, 0, 8, 0, 0, 0 }, // Node 2
        //     { 0, 5, 8, 0,10,15, 0 }, // Node 3
        //     { 0, 0, 0,10, 0, 6, 2 }, // Node 4
        //     { 0, 0, 0,15, 6, 0, 6 }, // Node 5
        //     { 0, 0, 0, 0, 2, 6, 0 }  // Node 6
        // };
        
        // int[][] graph = {
        //                     {0,2,6},
        //                     {2,0,3},
        //                     {6,3,0}
        //                 };
        
        int V = graph.length;
        findShortestPath(graph, 0, V);

    }
}
