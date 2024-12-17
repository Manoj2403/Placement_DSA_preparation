import java.util.*;

class EqualSplitSub {
    // static boolean prodSubArray(int[] arr, int start, int end, int val) {
    //     int prod = 1;
    //     for (int i = start; i <= end; i++) {
    //         prod *= arr[i];
    //         if (prod == val) {
    //             return true;
    //         } else if (prod > val) {
    //             return false;
    //         }
    //     }
    //     return false;
    // }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);

    //     // int n = sc.nextInt();
    //     // int arr[] = new int[n];
    //     int arr[]={6,6,6,36};
    //     int n = arr.length;
    //     // for(int i=0;i<n;i++){
    //     //     arr[i] = sc.nextInt();
    //     // }
    //     int max = 0;
    //     int element = 0;

    //     for (int i = 0; i < n; i++) {
    //         int currMax = 0;
    //         for (int k = 0; k < i; k++) {
    //             if(prodSubArray(arr, k, i - 1, arr[i]))
    //                 currMax++;
    //         }
    //         for (int k = i + 1; k < n; k++) {
    //             if(prodSubArray(arr, k, n - 1, arr[i]))
    //                 currMax++;
    //         }
    //         System.out.println(arr[i] + " Current Max is : "+currMax +" ");
    //         currMax++;

    //         if (currMax > max) {
    //             max = currMax;
    //             element = arr[i];
    //         }
    //     }

    //     System.out.println("Element : " + element + " Maximum : " + max);
    // }

//------------------------------------Below one if for Mutually exclusive subarray i.e(No element will occur again in any other partition sub array----------------------->
    static int prodSubArray(int[] arr, int start, int end, int val) {
        int prod = 1;
        int count=0;
        for (int i = start; i <= end; i++) {
            if(i>0 && arr[i]==1 && arr[i]*arr[i-1]==val)
                count++;
            
            prod *= arr[i];
            if (prod == val) {
                count++;
                prod=1;
            } else if (prod > val) {
                prod=1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[]={36,6,6,6,12};
        int n = arr.length;
        int max = 0;
        int element = 0;

        for (int i = 0; i < n; i++) {
            int currMax = 0;
            // for (int k = 0; k < i; k++) {
                currMax += prodSubArray(arr, 0, i - 1, arr[i]);
            // }
            // for (int k = i + 1; k < n; k++) {
                currMax += prodSubArray(arr, i+1, n - 1, arr[i]);
            // }
            System.out.println(arr[i] + " Current Max is : "+currMax +" ");
            currMax++;

            if (currMax > max) {
                max = currMax;
                element = arr[i];
            }
        }

        System.out.println("Element : " + element + " Maximum : " + max);
    }
}




        