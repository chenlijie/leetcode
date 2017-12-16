package linkedin;

/**
 * Created by chenlijie on 12/11/17.
 */
public class MaxSubsequenceSkipOne {

//    http://www.geeksforgeeks.org/maximum-sum-subarray-removing-one-element/
    static int max(int[] nums) {
        if (nums.length == 0)
            return 0;

        int skip = 0;
        int notSkip = nums[0];
        int max = Math.max(skip, notSkip);

        for (int i = 1; i < nums.length; i++) {
            skip = Math.max(0, notSkip);
            notSkip = Math.max(nums[i], nums[i] + notSkip);

            max = Math.max(max, Math.max(notSkip, skip));
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(max(new int[]{1, -1, -1, 3, 4}) == 7);
        System.out.println(max(new int[]{4, -1, 2}) == 5);
        System.out.println(max(new int[]{4, -1, 2, -1, -1, 3}) == 6);
    }
}
