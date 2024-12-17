import java.util.*;

class PendulumSort {
    public static void pendulumSort(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int res[] = new int[n];
        int op = 1;
        int mid = (n - 1) / 2;
        res[mid] = arr[0];
        for (int i = 1; i <= mid; i++) {
            res[mid + i] = arr[op++];
            res[mid - i] = arr[op++];
        }
        if(n%2==0){
            res[res.length-1] = arr[op++];
        }
        System.out.println("\nAfter Sorting:");
        for (int i : res) {
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr = { 1,2,3,5,4,6,7,8,9,10};
        System.out.println("Before Sorting:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        pendulumSort(arr);
    }
}