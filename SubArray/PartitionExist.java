public class PartitionExist {
    public static String isPartitionExist(int[] arr,int n){
        int leftMax;
        int rightMin;
        for(int i=0;i<n-1;i++){
            leftMax = arr[0];
            int j;
            for(j=0;j<=i;j++){
                if(arr[j]>leftMax)
                    leftMax = arr[j];
            }
            rightMin = arr[j];
            for(int k=j;k<n;k++){
                if(rightMin>arr[k])
                    rightMin = arr[k];
            }
            if(rightMin>leftMax){
                for(int start=0;start<=i;start++)
                    System.out.print(arr[start]+" ");
                System.out.println();
                for(int m=j;m<n;m++)
                    System.out.print(arr[m]+" ");
                return "";
            }
        }
        return "Impossible";
    }
    public static void main(String[] args) {
        int[] arr = {5,3,2,7,9};
        int N = 5;
        System.out.println(isPartitionExist(arr,N));
    }

    //1)Generally for the Every rightsubarray is strictly greater than left subarray i.e leftSubArray max is minimum and rightSubArray min is maximum
    //compared to leftMax and rightMin
    // 2)consider 0 as LeftMax and make it as subarray and rest of the element as right subarray 
    // now iterate through left to find max and iterate through right to find min
    //3)Now campare rightMin>leftMax then subarry partition is "possible" 
    // 4)If no compare is true through the full iteration then "Impossible"
    // Example:{5,3,2,7,9}----------->Partition is possible
    //         {5,3,7,9,2}----------->Partition is impossible
    //         {9,8,7,4,2}----------->Partition is impossible
}
