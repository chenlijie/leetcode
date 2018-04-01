package microsoft;

import utility.Utils;

public class SortColor {

    static void sortColors(int[] nums) {
        int len = nums.length;

        for (int i = 0, j = len - 1, k = 0; k <= j; k++) {
            if (nums[k] == 0) {
                swap(nums, k, i);
                i++;

                while (k < j && nums[k] == 2) {
                    swap(nums, k, j);
                    j--;
                }
            } else if (nums[k] == 2) {
                while (k < j && nums[k] == 2) {
                    swap(nums, k, j);
                    j--;
                }

                if (nums[k] == 0) {
                    swap(nums, k, i);
                    i++;
                }
            }
        }

        Utils.printArray(nums);
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        sortColors(new int[] {2, 1, 2});
    }
}
