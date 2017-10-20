package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 10/12/17.
 */
public class Continuous_Subarray_Sum_523 {

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (k != 0) {
                sum %= k;
            }

            if (map.containsKey(sum)) {
                if (i > 1 + map.get(sum)) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }

    public static boolean checkSubarraySum2(int[] nums, int k) {

        int len = nums.length;
        int[] sums = new int[len+1];

        for (int i = 0; i < len; i++) {
            sums[i+1] = sums[i] + nums[i];
        }

        for (int i = 0; i < len; i++) {
            for (int j = i+2; j <= len; j++) {
                if (k == 0 && (sums[j]-sums[i]) == 0 || k != 0 && (sums[j]-sums[i]) % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{0}, 0));
    }
}
