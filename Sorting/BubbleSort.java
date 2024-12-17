public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1, 3, 4};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
