package medium;

import java.util.PriorityQueue;

/**
 * Created by chenlijie on 5/18/17.
 */
public class Kth_Largest_Element_in_an_Array_215 {

    //quick select

    public int findKthLargest2(int[] nums, int k) {

        int[] x = new int[nums.length];

        for (int i = 0; i < x.length; i++) {
            x[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    x[j] += 1;
                } else {
                    x[i] += 1;
                }
            }
        }

        for (int i = 0; i < x.length; i++) {
            if (x[i] == k) {
                return nums[i];
            }
        }

        return -1;
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(nums, i, len);
        }

        for (int i = 0; i < k - 1; i++) {
            swap(nums, 0, len - 1 - i);
            heapify(nums, 0, len - 1 - i);
        }

        return nums[0];
    }

    void heapify(int[] nums, int i, int len) {
        int largest = i;

        if (2 * i + 1 < len && nums[largest] < nums[2 * i + 1]) {
            largest = 2 * i + 1;
        }
        if (2 * i + 2 < len && nums[largest] < nums[2 * i + 2]) {
            largest = 2 * i + 2;
        }

        if (i != largest) {
            swap(nums, i, largest);
            heapify(nums, largest, len);
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int findKthLargest3(int[] nums, int k, int lo, int hi) {
        if (lo > hi) return Integer.MAX_VALUE;

        int pivot = nums[hi];

        int j = lo;
        for (int i = lo; i < hi; i++) {
            if (nums[i] >= pivot) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j, hi);

        if (k == j + 1) {
            return nums[j];
        } else if (k > j + 1) {
            return findKthLargest3(nums, k, j + 1, hi);
        } else {
            return findKthLargest3(nums, k, lo, j - 1);
        }
    }

    public int findKthLargest5(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        System.out.println(new Kth_Largest_Element_in_an_Array_215().findKthLargest5(new int[]{3, 1, 2, 4}, 2));

        System.out.println(Integer.MAX_VALUE/103);
        System.out.println(Math.pow(103, 10600));
    }

}
