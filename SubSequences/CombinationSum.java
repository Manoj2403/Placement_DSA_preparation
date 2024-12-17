import java.util.*;

public class CombinationSum {
    public static void genSeq(int[] arr, int idx, int target, ArrayList<Integer> list) {
        if (idx >= arr.length)
            return;
        if (target == 0) {
            System.out.println(list);
            return;
        }
        if (target >= arr[idx]) {
            list.add(arr[idx]);
            genSeq(arr, idx, target - arr[idx], list);
            list.remove(list.size() - 1);
        }
        genSeq(arr, idx + 1, target, list);
    }

    public static void main(String[] args) {
        int[] arr = { 100, 50, 4, 6, 3, 9 };
        int target = 10;
        ArrayList<Integer> list = new ArrayList<>();
        genSeq(arr, 0, target, list);
    }
}

