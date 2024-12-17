import java.util.*;

class Graph {
    int vertices;
    ArrayList<ArrayList<Integer>> adj;

    Graph(int V) {
        vertices = V;
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<ArrayList<Integer>> getList(){
        return adj;
    }
    public void addEdge(int source, int dest) {
        if (isValidVertex(source) && isValidVertex(dest)) {
            adj.get(source).add(dest);
            adj.get(dest).add(source);     //-------------------Make this line to command out while using graph as "Directed Egde Graph"
        }
        else
            System.out.println("Vertex is Not valid");
    }

    private boolean isValidVertex(int vertex) {
        return vertex >= 0 && vertex < vertices;
    }
    public void printGraph(){
        Iterator<ArrayList<Integer>> itr = adj.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}

public class AdjList {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        


            graph.addEdge(1, 2);
            graph.addEdge(1, 3);
            graph.addEdge(2, 3);
            // graph.addEdge(2, 3);
            graph.addEdge(2, 4);
            graph.printGraph();

    }
}
