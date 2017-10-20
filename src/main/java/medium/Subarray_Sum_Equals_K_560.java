package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 8/15/17.
 */
public class Subarray_Sum_Equals_K_560 {


    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += sums.getOrDefault(sum - k, 0);
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }
}
