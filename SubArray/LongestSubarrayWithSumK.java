import java.util.*;
import java.math.*;
public class LongestSubarrayWithSumK{
    static int findMaxLen(int[] arr,int k){
        int maxLen=0;
        int preSum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            preSum+=arr[i];
            if (preSum == k) {
                maxLen = i + 1;
            }
            int diff = preSum-k;
            if(map.containsKey(diff)){
                maxLen = Math.max(maxLen,i-map.get(diff));
            }
            if(!map.containsKey(preSum)){
                map.put(preSum,i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,0,0,0,3};
        System.out.println(findMaxLen(arr,3));
    }
}