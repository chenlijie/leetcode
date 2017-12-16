package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 11/8/17.
 */
public class Maximum_Size_Subarray_Sum_Equals_k_325 {

    static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> subSums = new HashMap<>();
        subSums.put(0, -1);
        int max = 0;
        int sum = 0;


        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (subSums.containsKey(sum - k)) {
                max = Math.max(max, i - subSums.get(sum - k));
            } else {
                subSums.putIfAbsent(sum, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayLen(new int[] {-2, -1, 4, 1, 1}, 3));
    }
}
