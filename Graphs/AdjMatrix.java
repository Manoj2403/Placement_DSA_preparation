// import java.util.*;

// class Graph {
//     private int vertices;
//     private int[][] adjacencyMatrix;
//     public Graph(int vertices) {
//         this.vertices = vertices;
//         this.adjacencyMatrix = new int[vertices][vertices];
//     }

//     //for 1-based indexing vertices can be  upto no.of vertices so matix size would be "size+1";
//     //this.adjacencyMatrix = new int[vertices+1][vertices+1];
//     public void addEdge(int source, int destination) {
//         if (isValidVertex(source) && isValidVertex(destination)) {
//             adjacencyMatrix[source - 1][destination - 1] = 1;
//             adjacencyMatrix[destination - 1][source - 1] = 1; // For an undirected graph
//         } else {
//             System.out.println("Invalid edge: " + source + " to " + destination);
//         }
//     }

//     public void printGraph() {
//         System.out.println("Adjacency Matrix:");
//         for (int[] row : adjacencyMatrix) {
//             System.out.println(Arrays.toString(row));
//         }
//     }

//     private boolean isValidVertex(int vertex) {
//         return vertex > 0 && vertex <= vertices;
//     }
// }

// public class AdjMatrix {
//     public static void main(String[] args) {
//         // Example usage
//         Graph graph = new Graph(3);
//         graph.addEdge(1, 2);
//         graph.addEdge(1, 3);
//         graph.addEdge(2, 3);

//         graph.printGraph();
//     }
// }


// Java implementation of the approach
// import java.io.*;

class AdjMatrix {
	static int[][] adj;
	static void addEdge(int x, int y)
	{
		adj[x][y] = 1;
		adj[y][x] = 1;
	}
	static void dfs(int start, boolean[] visited)
	{
		System.out.print(start + " -> ");
		visited[start] = true;
		for(int i=0;i<adj[start].length;i++){
		    if(adj[start][i] == 1 && (!visited[i]))
		        dfs(i,visited);
		}
	}

	public static void main(String[] args)
	{
		// number of vertices
		int v = 5;

		// adjacency matrix
		adj = new int[v][v];

		addEdge(4, 1);
		addEdge(0, 2);
		addEdge(0, 3);
		addEdge(0, 4);

        boolean[] visited = new boolean[v];
		dfs(0, visited);
	}
}
