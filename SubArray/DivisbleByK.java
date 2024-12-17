import java.util.*;
public class DivisbleByK {
    public static void findDivisbleByK(int[] arr,int k){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int preSum = 0;
        for(int num : arr){
            preSum += num;
            int rem = preSum%k;
            if(map.containsKey(rem)){
                System.out.println(preSum-map.get(rem));
            }
            map.put(rem,preSum);
        }

    }
    public static void main(String[] args) {
        int[] arr = {3,5,5,1,2};
        int k = 3;
        findDivisbleByK(arr,k);
    }
}
