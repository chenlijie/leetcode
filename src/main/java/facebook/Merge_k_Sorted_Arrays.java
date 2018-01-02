package facebook;

/**
 * Created by chenlijie on 12/17/17.
 */
public class Merge_k_Sorted_Arrays {

    static class HeapNode {
        public HeapNode(int element, int i, int j) {
            this.element = element;
            this.i = i;
            this.j = j;
        }
        int element;
        int i; // index of array from where element is took
        int j; // index of next element to be took
    }


    public static int[] mergeKSortedArrays(int[][] arrays) {
        if (arrays.length == 0)
            return new int[0];

        int m = arrays.length;
        int n = arrays[0].length;

        HeapNode[] heap = new HeapNode[m];
        for (int i = 0; i < m; i++) {
            heap[i] = new HeapNode((arrays[i][0]), i, 1);
        }

        for (int i = m/2-1; i >= 0; i--) {
            buildMinHeap(i, m, heap);
        }

        int[] ans = new int[m*n];
        int i = 0;

        while (m > 0) {
            ans[i] = heap[0].element;
            if (heap[0].j >= n) {
                heap[0] = heap[m-1];
                m--;
            } else {
                heap[0].element = arrays[heap[0].i][heap[0].j];
                heap[0].j += 1;
            }
            buildMinHeap(0, m, heap);
            i++;
        }

        return ans;
    }

    static void buildMinHeap(int i, int size, HeapNode[] heap) {
        int largest = i;
        if (2*i + 1 < size && heap[2*i + 1].element < heap[largest].element) {
            largest = 2*i + 1;
        }
        if (2*i + 2 < size && heap[2*i + 2].element < heap[largest].element) {
            largest = 2*i + 2;
        }
        if (largest != i) {
            swap(largest, i, heap);
            buildMinHeap(largest, size, heap);
        }
    }

    static void swap(int i, int j, HeapNode[] heap) {
        HeapNode t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }
}
