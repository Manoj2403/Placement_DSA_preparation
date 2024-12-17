// package LeetCode;
import java.util.*;

public class PascalTriangle {

    static int findNcR(int row,int col){
        row=row-1;
        col=col-1;
        int ans=1;
        for(int i=0;i<col;i++){
            ans=ans*(row-i);
            ans/=(i+1);
        }
        return ans;
    }
    static void printPascal(int numRows){
        int ans=1;
        for(int i=1;i<=numRows;i++){
            for(int j=1;j<=i;j++){
                ans = findNcR(i, j);
                System.out.print(ans+" ");
            }
            System.out.println();
        }


    }
    //By usnig ArrayList
    public static List<Integer> generateRows(int rows){
        int ans=1;
        List<Integer> list = new ArrayList();
        list.add(1);
        for(int i=1;i<rows;i++){
            ans=ans*(rows-i);
            ans=ans/i;
            list.add(ans);
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numRows = sc.nextInt();
        // List<List<Integer>> ansRow = new ArrayList<>();
        // for(int i=1;i<=numRows;i++){
        //     List<Integer> row = generateRows(i);
        //     ansRow.add(row);
        // }
        // System.out.println(ansRow);

        printPascal(numRows);
    }
}