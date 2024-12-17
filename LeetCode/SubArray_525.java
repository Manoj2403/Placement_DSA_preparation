// class SubArray_525 {
//     public int count(int[] nums,int start,int end){
//         int count_0,count_1;
//         count_0=count_1=0;
//         while(start<=end){
//             if(nums[start++]==0)
//                 count_0++;
//             else  
//                 count_1++;
//         }
//         return end-start+1 ;
//     }
//     public int findMaxLength(int[] nums) {
//         int max=0;
//         int n = nums.length;
//         max = count(nums, 1, n-1);
//         return max;
//         // for(int start=0;start<n;start++){
//         //     for(int end=start;end<n;end++){
//         //         int len = count(nums,start,end);
//         //         if(len!=-1 && len>max)
//         //             max=len;
//         //     }
//         // }
//         // return max;
//     }
//     public static void main(String[] args) {
//         SubArray_525 obj = new SubArray_525();
//         int[] arr = {0,1,0};
//         System.out.println(obj.findMaxLength(arr));
//     }
// }

public class SubArray_525 {
    public static int longestSubarrayWithSumK(int[] arr, int k){
        int n = arr.length;
        int max = 0;
        for(int start=0;start<n;start++){
            int sum = 0;
            for(int end=start;end<n;end++){
                sum += arr[end];
                if(sum == k){
                    max = Math.max(max, end-start+1);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,3};
        System.out.println(longestSubarrayWithSumK(arr, 2));
    }
}