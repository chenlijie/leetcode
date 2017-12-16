package medium;

/**
 * Created by chenlijie on 11/18/17.
 */
public class Subarray_Product_Less_Than_K_713 {

    static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return 0;

        int len = nums.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            int product = 1;
            int j = i;
            while (j < len) {
                product *= nums[j++];
                if (product < k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
    }

}
