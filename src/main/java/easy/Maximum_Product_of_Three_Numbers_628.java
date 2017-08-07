package easy;

import java.util.Arrays;

/**
 * Created by chenlijie on 8/7/17.
 */
public class Maximum_Product_of_Three_Numbers_628 {

    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length-1;

        return Math.max(nums[len]*nums[len-1]*nums[len-2], nums[0]*nums[1]*nums[len]);
    }
}
