package easy;

import java.util.Arrays;

/**
 * Created by chenlijie on 8/5/17.
 */
public class Array_Partition_I_561 {


    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }

        return sum;
    }
}
