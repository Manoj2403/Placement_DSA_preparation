// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class SelectionSort {
    public static void selectionSort(int[] arr){
        int minIdx;
        for(int i=0;i<arr.length;i++){
            minIdx = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[minIdx])
                    minIdx=j;
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,4,1,5,3,2,3,8,9,15,10};
        selectionSort(arr);
        for(int num : arr)
            System.out.print(num+ " ");
    }
}