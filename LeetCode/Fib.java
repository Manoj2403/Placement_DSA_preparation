// public class Fib { ---------------------------> TC : O(2^n)
//     public static int fib(int n) {
//         if(n==0||n==1)
//             return n;
//         int prev=0,curr=1,next=0;
//         for(int i=2;i<=n;i++){
//             next=prev+curr;
//             prev=curr;
//             curr=next;            
//         }
//         return next;
//     }
//     public static void main(String[] args) {
//         System.out.println(fib(3));
//     }
// }


//Optimized Code ----------------------------->TC:O(n)
public class Fib {
    public static int fib(int n) {
        if(n==0||n==1)
            return n;
        int[] arr = new int[n];
        
        if(arr[n-1]!=0)
            return arr[n];
        arr[n-1]=fib(n-1)+fib(n-2);
        return arr[n-1];
    }
    public static void main(String[] args) {
        System.out.println(fib(40));
    }
}
