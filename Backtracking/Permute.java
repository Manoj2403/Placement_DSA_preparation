import java.util.*;
//Backtracking is to Do the process and undo it and try next process to get the result
public class Permute {

    static void swapper(char[] arr, int idx1, int idx2) {
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static String toString(char[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++)
            str += arr[i];
        return str;
    }
    static int num = 0;
    static void func(char[] arr, int work_idx) {
        if (work_idx == arr.length) {
            System.out.print(toString(arr) + " ");
            num++;
            return ;
        }
        for (int idx = work_idx; idx < arr.length; idx++) {
            swapper(arr, work_idx, idx);//doing operation
            func(arr, work_idx + 1);
            swapper(arr, work_idx, idx);//undoing operation
        }
    }

    public static void main(String[] args) {
        String str = "ABCD";
        char[] arr = str.toCharArray();
        func(arr, 0);
        System.out.println("\n"+num);
    }
}