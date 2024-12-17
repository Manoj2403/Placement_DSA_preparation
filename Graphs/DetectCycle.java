import java.util.*;
public class DetectCycle {
    // Function to detect cycle in a directed graph.
    public boolean checkCycle(boolean[] vis, ArrayList<ArrayList<Integer>> adj,int v){
        if(vis[v])
            return true;
        else
            vis[v] = true;
        for(Integer neighbour : adj.get(v)){
            if(checkCycle(vis,adj,neighbour))
                return true;
        }
        vis[v] = false;
        
        return false;
        
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (checkCycle(vis, adj,i)) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        
            
            ArrayList<ArrayList<Integer>> adj = graph.getList();
            //-----------------Cycle Producing Example
            //--------------------While checking make sure that AdjList.java file "addEdge" function has commanded out to directedEdge graph-------
            // graph.addEdge(0, 1);
            // graph.addEdge(2, 1);
            // graph.addEdge(1, 2);
            // graph.addEdge(2, 3);

            //---------------------------No Cycle Producing Example
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 2);
            graph.addEdge(2, 3);

            // graph.addEdge(0,1);
            DetectCycle detectCycle = new DetectCycle();
            if(detectCycle.isCyclic(4,adj))
                System.out.println("Cycle Found");
            else    
                System.out.println("No Cycle Found");
    }
}