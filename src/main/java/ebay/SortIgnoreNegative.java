package ebay;

import utility.Utils;

public class SortIgnoreNegative {


    static void sort(int[] nums) {
        partition(nums, 0, nums.length - 1);
        Utils.printArray(nums);
    }

    static void partition(int[] nums, int s, int e) {
        if (s < e) {
            int pivot = Math.abs(nums[e]);

            int j = s;
            for (int i = s; i < e; i++) {
                if (Math.abs(nums[i]) <= pivot) {
                    swap(nums, i, j);
                    j++;
                }
            }

            swap(nums, j, e);

            partition(nums, s, j - 1);
            partition(nums, j + 1, e);
        }
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        sort(new int[] {4, 3, 1, 5, 2});
        sort(new int[] {4, -3, 1, -5, 2});

        sort(new int[] {4, 2, -3, 1, -5, 3, 5, 2, -3});
    }
}
