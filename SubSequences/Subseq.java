// // package SubSequences;
// import java.util.*;

// public class Subseq {
//     static int count=0;
//     public static void genSeq(int[] arr, int idx, ArrayList<Integer> list){
//         int n = arr.length;
//         if(idx>=n){
//             // Iterator itr = list.iterator();
//             // while(itr.hasNext()){
//             //     System.out.print(itr.next()+" ");
//             // }
//             // System.out.println();
//             System.out.println(new ArrayList<>(list));
//             count++;
//             return;
//         }
//         //work for that idx--Next two lines
//         list.add(arr[idx]);
//         genSeq(arr,idx+1,list);

//         //don't work for that index--Next two lines
//         list.remove(list.size()-1);
//         genSeq(arr,idx+1,list);

//     }
//     public static void main(String[] args) {
//         int[] arr = {1,2,3,4,5,6};
//         ArrayList<Integer> list = new ArrayList<Integer>();
//         genSeq(arr,0,list);
//         System.out.println("Total subset count :"+count);
//     }
// }


import java.util.*;

public class Subseq {
    static int count = 0;
    public static void genSeq(String str, int idx, String current) {
        int n = str.length();
        if (idx >= n) {
            System.out.println(current);
            count++;
            return;
        }
        genSeq(str, idx + 1, current + str.charAt(idx));//take and go
        genSeq(str, idx + 1, current);//dont take and go
    }

    public static void main(String[] args) {
        String str = "abc";
        genSeq(str, 0, "");
        System.out.println("Total subset count: " + count);
    }
}
