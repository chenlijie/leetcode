package facebook.fblist;

import utility.Utils;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MSortedArray {

    class Node {
        int val;
        int pos;
        int start;
        int end;

        public Node(int val, int pos, int start, int end) {
            this.val = val;
            this.pos = pos;
            this.start = start;
            this.end = end;
        }
    }

    void sort(int[] nums, int m) {
        if (m <= 1) return;

        int len = nums.length;
        Node[] nodes = new Node[m];
        for (int i = 0; i < m; i++) {
            nodes[i] = new Node(nums[i * m], i,i * m, Math.min((i + 1) * m, len));
        }

        int[] ans = new int[len];

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (int i = 0; i < m; i++) {
            queue.offer(nodes[i]);
        }

        int i = 0;
        int last = m - 1;

        while (last >= 0) {
            Node node = queue.poll();
            ans[i++] = node.val;
            if (node.start >= node.end - 1) {
                last--;
            } else {
                node.start++;
                node.val = nums[node.start];
                queue.offer(node);
            }
        }

        for (int j = 0; j < len; j++) {
            nums[j] = ans[j];
        }
    }

    void sort2(int[] nums, int m) {
        if (m <= 1) return;

        int len = nums.length;

        Set<Integer> indices = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> nums[i1]-nums[i2]);

        indices.add(0);
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i-1]) {
                indices.add(i);
            }
        }

        for (int i : indices) {
            queue.offer(i);
        }

        indices.add(len);

        int[] ans = new int[len];

        int i = 0;
        while (i < len) {
            int idx = queue.poll();
            ans[i++] = nums[idx];

            if (indices.add(idx + 1)) {
                queue.offer(idx + 1);
            }
        }

        for (int j = 0; j < len; j++) {
            nums[j] = ans[j];
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,4,9,1,5,8,3,6,7,1,10};
//        int[] nums = new int[] {3,4,1,2};
        new MSortedArray().sort2(nums, 4);
        Utils.printArray(nums);
    }
}
