package hard;

import utility.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sliding_Window_Maximum_239 {
    class Node {
        int idx;
        int val;

        public Node (int val) {
            this.val = val;
        }

        public Node (int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", val=" + val +
                    '}';
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0 || nums.length == 0)
            return new int[0];

        int len = nums.length;
        Node[] nodes = new Node[len];
        Map<Integer, Node> loc = new HashMap<>();

        for (int i = 0; i < len; i++) {
            nodes[i] = new Node(i, nums[i]);
            loc.put(i, nodes[i]);
        }

        Node[] heap = Arrays.copyOfRange(nodes, 0, k);
        for (int i = k / 2 - 1; i >= 0; i--) {
            buildMaxHeap(heap, i, k);
        }

        int[] ans = new int[len - k + 1];
        ans[0] = heap[0].val;

        for (int i = k, j = 1; i < len; i++) {

            Node removal = loc.get(i - k);
            nodes[i].idx = removal.idx;

            heap[removal.idx] = nodes[i];

            siftUp(heap, removal.idx);
            siftDown(heap, removal.idx, k);

            ans[j++] = heap[0].val;
        }

        return ans;
    }

    void siftDown(Node[] heap, int i, int size) {
        buildMaxHeap(heap, i, size);
    }

    void siftUp(Node[] heap, int i) {
        if (i > (i-1)/2 && heap[i].val > heap[(i-1)/2].val) {
            swap(heap, i, (i-1)/2);
            siftUp(heap, (i-1)/2);
        }
    }

    void buildMaxHeap(Node[] heap, int i, int size) {
        int largest = i;

        if (2*i + 1 < size && heap[largest].val < heap[2*i + 1].val) {
            largest = 2*i + 1;
        }

        if (2*i + 2 < size && heap[largest].val < heap[2*i + 2].val) {
            largest = 2*i + 2;
        }

        if (largest != i) {
            swap(heap, largest, i);
            buildMaxHeap(heap, largest, size);
        }
    }

    void swap(Node[] heap, int i, int j) {
        Node t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
        heap[i].idx = i;
        heap[j].idx = j;
    }

    public static void main(String[] args) {
        Sliding_Window_Maximum_239 win = new Sliding_Window_Maximum_239();
        int[] ans = win.maxSlidingWindow(new int[] {1,3,0,2}, 3);
        Utils.printArray(ans);
    }
}
