package medium;

/**
 * Created by chenlijie on 9/11/17.
 */
public class Wiggle_Sort_280 {

    /**
     *
     * Wiggle Sort
     * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
     * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
     *
     */

    public static void wiggleSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i-1] > nums[i]) {
                    int t = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = t;
                }
            } else {
                if (nums[i-1] < nums[i]) {
                    int t = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = t;
                }
            }
        }

        for (int i : nums) {
            System.out.print(i + "  ");
        }
    }

    public static void main(String[] args) {
        wiggleSort(new int[]{3, 5, 2, 1, 6, 4});
    }

}
