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
        System.out.println();
    }

    public static void wiggleSort2(int[] nums) {
        if (nums == null) {
            return;
        }

        for (int i = 1; i < nums.length; i += 2) {
            int largest = i;

            if (nums[largest] < nums[i-1]) {
                largest = i - 1;
            }

            if (i + 1 < nums.length && nums[largest] < nums[i+1]) {
                largest = i + 1;
            }

            if (largest != i) {
                int t = nums[largest];
                nums[largest] = nums[i];
                nums[i] = t;
            }
        }

        for (int i : nums) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        wiggleSort(new int[]{3, 5, 2, 1, 6, 4});
        wiggleSort2(new int[]{3, 5, 2, 1, 6, 4});
        wiggleSort2(new int[]{3, 5, 2, 1});
    }

}
