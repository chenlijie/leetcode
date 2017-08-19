package medium;

/**
 * Created by chenlijie on 8/15/17.
 */
public class Minimum_Size_Subarray_Sum_209 {

    public static int minSubArrayLen(int s, int[] nums) {

        int sum = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= s) {

                min = Math.min(min, i-j+1);
                sum -= nums[j++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
