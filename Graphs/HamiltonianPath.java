public class HamiltonianPath {
    
    public static void printPath(int[] path, int V) {
        for (int i = 0; i < V; i++) {
            System.out.print((char)(path[i] + 65));
            if (i < V - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static boolean findHamiltonianPath(int[][] adjMat, int src, int V, boolean[] vis, int[] path, int pos) {
        vis[src] = true;
        path[pos] = src;
        if (pos == V-1) {
            return true;
        }
        for (int dest = 0; dest < V; dest++) {
            if (adjMat[src][dest] == 1 && !vis[dest]) {
                if (findHamiltonianPath(adjMat, dest, V, vis, path, pos + 1)) {
                    return true;
                }
            }
        }
        vis[src] = false;
        return false; 
    }

    public static void main(String[] args) {
        // Adjacency matrix representation of the graph
        int[][] adjMat = {
                            {0,1,0,0,0,0,0,1,1},
                            {1,0,1,0,0,0,0,1,0},
                            {0,1,0,1,0,0,0,0,0},
                            {0,0,1,0,1,0,0,0,0},
                            {0,0,0,1,0,1,1,0,0},
                            {0,0,0,0,1,0,1,0,0},
                            {0,0,0,0,1,1,0,0,0},
                            {1,1,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,1,0}
                            // {0,1,1,0,0},
                            // {1,0,0,1,0},
                            // {1,0,0,1,0},
                            // {0,1,1,0,1},
                            // {0,1,0,1,0}
                        };
                        
        int V = 9;  // Number of vertices
        boolean[] vis = new boolean[V]; 
        int[] path = new int[V]; 
        if (findHamiltonianPath(adjMat, 0, V, vis, path, 0)) {
            System.out.println("Hamiltonian Path found:");
            printPath(path, V);
        } else {
            System.out.println("No Hamiltonian Path exists.");
        }
    }
}
