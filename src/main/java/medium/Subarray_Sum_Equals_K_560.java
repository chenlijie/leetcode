package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 8/15/17.
 */
public class Subarray_Sum_Equals_K_560 {

    public static int subarraySum2(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{-1, 1, -1, 2, -2, 2}, 2));
    }
}
