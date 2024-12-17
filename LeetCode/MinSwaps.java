public class MinSwaps {

    static int minSwaps(int[] nums){
        int even=0;
        int count=0;
        for(int i:nums){
            if(i%2==0)
                ++even;
        }
        for(int i=0;i<even;i++){
            if(nums[i]%2==1)
                ++count;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,9,4,6,8};
        System.out.println(minSwaps(nums));
    }
}
