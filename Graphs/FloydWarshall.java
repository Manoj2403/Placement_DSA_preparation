public class FloydWarshall {
    static int count=0;
    public static void findAllShortestPath(int[][] matrix){
        int n = matrix.length;
        for(int via=0;via<n;via++){
            count++;
            for(int src=0;src<n;src++){
                count++;
                for(int dest=0;dest<n;dest++){
                    count++;
                    if(matrix[src][via]!=-1 && matrix[via][dest]!=-1){
                        int cost = matrix[src][via]+matrix[via][dest];
                        int existCost=matrix[src][dest];
                        if(existCost==-1)
                            matrix[src][dest]=cost;
                        else
                        {
                            matrix[src][dest] = Math.min(existCost,cost);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        // int[][] adjMatrix = {
        //     {0, 1, 43,67},
        //     {1, 0, 6,5},
        //     {-1, -1, 0,2},
        //     {4, 6, 2,0}
        // };
        int[][] adjMatrix = {
            // 1  2  3  4
            { 0, 3, -1, 5 }, // Node 1
            { 2, 0, -1, 4 }, // Node 2
            { -1, 1, 0, -1 }, // Node 3
            { -1, -1, 2, 0 }  // Node 4
        };
        
        findAllShortestPath(adjMatrix);
        int n = adjMatrix.length;
        for(int i=0;i<n;i++,System.out.println()){
            for(int j=0;j<n;j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
        }
        // System.out.println(count);
    }
}
