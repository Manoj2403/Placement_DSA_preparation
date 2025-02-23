public class QuickSort{
    // static int partition(int[] arr,int start,int end){
    //     int pivot=arr[end];
    //     int pi_idx=start-1;
    //     for(int i=start;i<end;i++){
    //         if(arr[i]<pivot){
    //             ++pi_idx;
    //             int temp = arr[i];
    //             arr[i] = arr[pi_idx];
    //             arr[pi_idx] = temp;
    //         }
    //     }
    //     ++pi_idx;
    //     int temp=arr[end];
    //     arr[end]=arr[pi_idx];
    //     arr[pi_idx]=temp;
    //     return pi_idx;
    // }
    // static void quickSort(int[] arr,int start,int end){
    //     if(start<end){
    //         int pi = partition(arr,start,end);
    //         quickSort(arr,start,pi-1);
    //         quickSort(arr,pi+1,end);
    //     }
    // }
    // public static void main(String[] ars){
    //     int[] arr = {60,52,35,82,86,91,55};
    //     quickSort(arr,0,6);
    //     for(int i:arr)
    //         System.out.print(i + " ");
    // }

    static void swap(int[] arr,int idx1,int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    static int partition(int[] arr,int left, int right){
        int pi_idx = right;
        right--;
        while(left<=right){
            if(arr[pi_idx]<arr[left] && arr[pi_idx]>arr[right])
            {
                swap(arr,left,right);
                left++;
                right--;
            }
            else if(arr[left]<=arr[pi_idx])
                left++;
            else 
                right--;
        }
        swap(arr,left,pi_idx);
        return left;
    }
    static void quickSort(int[] arr, int start, int end){
        if(start<end){
            int pi = partition(arr,start,end);    
            quickSort(arr,start,pi-1);
            quickSort(arr,pi+1,end);
        }
    }
	public static void main(String[] args) {
	   // int[] arr = {6,5,4,3,2,1};
	    int size = 5;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }

	    int n = arr.length-1;
		quickSort(arr,0,n);
		for(int i : arr){
		    System.out.print(i+" ");
		}
	}
}