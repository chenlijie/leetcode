package sort;

import java.util.Arrays;

/**
 * Created by chenlijie on 8/27/17.
 */
public class Combination_Sum_IV_377 {


    public int combinationSum42(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {

            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }

        return dp[target];
    }

    public int combinationSum4(int[] nums, int target) {

        Arrays.sort(nums);
        int[] result = new int[1];
        combinationSum4(nums, target, result);
        return result[0];

    }

    private boolean combinationSum4(int[] nums, int target, int[] result) {

        if (target == 0) {
            result[0]++;
            return true;
        }

        if (target < 0) {
            return true;
        }

        for (int i = 0; i < nums.length; i++) {
            boolean b = combinationSum4(nums, target-nums[i], result);
            if (b) {
                break;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Combination_Sum_IV_377().combinationSum4(new int[]{1,2,3}, 35));
        System.out.println(new Combination_Sum_IV_377().combinationSum42(new int[]{1,2,3}, 35));
    }
}
