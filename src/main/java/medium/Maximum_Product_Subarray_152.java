package medium;

/**
 * Created by chenlijie on 8/15/17.
 */
public class Maximum_Product_Subarray_152 {

    /*

    [2, 3, -2, 4, 2, 0, -2, 4, 5, 0, -1, -6, -6, 0, 9, -1, 9, -2]

     */

    static int maxProduct(int[] nums) {

        int max = nums[0];
        int minHere = max;
        int maxHere = max;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0 && maxHere >= 0 || nums[i] < 0 && maxHere < 0) {
                maxHere = Math.max(nums[i], maxHere*nums[i]);
            } else {
                minHere = Math.min(nums[i], minHere*nums[i]);
            }

            max = Math.max(max, maxHere);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-4, -3}));
    }
}
