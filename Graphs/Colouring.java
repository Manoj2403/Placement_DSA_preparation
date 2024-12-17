public class Colouring {
    public static boolean isSafe(int[][] graph,int colorSelected,int[] colour, int src){
        for(int i=0;i<colour.length;i++){
            if(graph[src][i]!=0 && colour[i]==colorSelected)
                return false;
        }
        return true;
    }
    public static boolean backtrack(int[][] graph,int M,int[] colour,int src){
        if(src==graph.length)
            return true;
        for(int colorSelected=1;colorSelected<=M;colorSelected++){
            if(isSafe(graph,colorSelected,colour,src)){
                colour[src] = colorSelected;
                if(backtrack(graph,M,colour,src+1))
                    return true;
                colour[src]=0;
            }
        }
        return false;
    }
    public static void printColour(int[] colour){
        for(int i=0;i<colour.length;i++){
            System.out.println(i+" "+colour[i]);
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
                            {0,1,1,1},
                            {1,0,1,1},
                            {1,1,0,1},
                            {1,1,1,0}
                        };
        int N = graph.length;
        int M = 4;
        int[] colour = new int[N];
        backtrack(graph,M,colour,0);
        printColour(colour);

    }
}