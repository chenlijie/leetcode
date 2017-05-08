package medium;

import java.util.Arrays;

/**
 *
 * https://discuss.leetcode.com/topic/2031/challenge-me-thx/17
 */
public class Single_Number_II_137 {

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        for (; i+3 < len; i=i+3) {
            if (0 != (nums[i]^nums[i+1]))https://connect14.uc.att.com/infosys/meet/?ExEventID=85830501
                    return nums[i];
        }
        return nums[i];
    }

    public static int singleNumber2(int[] nums) {

        int len = nums.length;
        int x;
        int sum = 0;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            x = (1<<i);

            for (int j = 0; j < len; j++) {
                if((nums[j]&x) != 0) {
                    sum++;
                }
            }

            if (sum%3 != 0) {
                result |= x;
            }
            sum = 0;
        }

        return result;
    }
}
