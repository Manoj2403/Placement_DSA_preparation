public class MaxPq {
    private Integer[] heap;
    int n;

    public MaxPq(int capacity) {
        heap = new Integer[capacity + 1];// Index 0 would be empty
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void swap(int parent_idx, int child_idx) {
        int temp = heap[parent_idx];
        heap[parent_idx] = heap[child_idx];
        heap[child_idx] = temp;
    }

    // insertion in Max Heap
    public void insert(int element) {
        if (n == heap.length - 1) {
            System.out.println("Heap is full cannot insert more elements at index " + (n + 1));
            return;
        }
        n++;
        heap[n] = element;
        swim(n);
    }

    private void swim(int child_idx) {
        // 1 based indexing so parent = child_idx/2
        int parent = child_idx / 2;
        while (child_idx > 1 && heap[parent] < heap[child_idx]) {
            int temp = heap[parent];
            heap[parent] = heap[child_idx];
            heap[child_idx] = temp;
            child_idx = parent;
            parent = child_idx / 2;
        }
    }

    // deletion in max Heap
    public int delMax() {
        if (isEmpty())
            return -1;
        int max = heap[1];
        swap(1, n);
        n--;
        sink(1);
        return max;
    }

    private void sink(int parent_idx) {
        while (2 * parent_idx <= n) {
            int leftChild = 2 * parent_idx;
            int rightChild = 2 * parent_idx + 1;
            if ((heap[leftChild] > heap[rightChild]) && heap[parent_idx] < heap[leftChild]) {
                swap(parent_idx, leftChild);
                parent_idx = leftChild;
            } else if (rightChild <= n && (heap[parent_idx] < heap[rightChild])) {
                swap(parent_idx, rightChild);
                parent_idx = rightChild;
            } else {
                break;
            }
        }
    }

    public void print() {
        for (int i = 1; i <= n; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public void getChildNodes(int parent_idx) {
        System.out.println(heap[2 * parent_idx] + " " + heap[2 * parent_idx + 1]);
        // 1 based indexing so left child = 2*parent
        // right child = 2*parent + 1
    }

    // HeapSort
    public void heapSort() {
        int originalSize = n; // Store the original size of the heap
        for (int i = 1; i <= originalSize; i++) {
            int val = delMax();
            heap[n + 1] = val;
        }
        n = originalSize;
    }

    public static void main(String[] args) {
        MaxPq maxHeap = new MaxPq(20);
        maxHeap.insert(7);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(8);
        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(1);
        maxHeap.insert(4);
        // System.err.println(maxHeap.size());
        maxHeap.print();
        // maxHeap.getChildNodes(2);
        // maxHeap.delMax();
        // maxHeap.print();
        // maxHeap.delMax();
        // maxHeap.print();

        // MaxPq maxHeap = new MaxPq(5);
        // maxHeap.insert(1);
        // maxHeap.insert(2);
        // maxHeap.insert(3);
        // maxHeap.insert(4);
        // maxHeap.insert(5);
        // maxHeap.insert(6);
        maxHeap.heapSort();
        maxHeap.print();
        System.err.println(maxHeap.size());
    }
}
