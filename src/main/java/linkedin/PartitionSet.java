package linkedin;

import java.util.Arrays;

/**
 * Created by chenlijie on 12/12/17.
 */
public class PartitionSet {

    static int partitionSet(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int n : nums) {
            sum += n;
        }

        boolean[][] dp = new boolean[len + 1][sum + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                if (dp[i-1][j] || (j >= nums[i-1] && dp[i-1][j-nums[i-1]])) {
                    dp[i][j] = true;
                }
            }
        }

        int min = sum;

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= sum; j++) {
                if (dp[i][j]) {
                    min = Math.min(min, Math.abs(sum-2*j));
                }
            }
        }

        return min;
    }

    static int partitionSet2(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int n : nums) {
            sum += n;
        }

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = sum; j >= 1; j--) {
                if (dp[j] || (j >= nums[i-1] && dp[j-nums[i-1]])) {
                    dp[j] = true;
                } else {
                    dp[j] = false;
                }
            }
        }

        int min = sum;

        for (int j = 0; j <= sum; j++) {
            if (dp[j]) {
                min = Math.min(min, Math.abs(sum-2*j));
            }
        }

        return min;
    }

    static int partitionSet3(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        helper(nums, 0, 0, sum);
        return min;
    }
    static int min = Integer.MAX_VALUE;

    static void helper(int[] nums, int i, int sumHere, int sum) {
        if (i == nums.length) {
            min = Math.min(Math.abs(sum-2*sumHere), min);
            return;
        }

        helper(nums, i+1, sumHere+nums[i], sum);
        helper(nums, i+1, sumHere, sum);
    }

    public static void main(String[] args) {
        System.out.println(partitionSet(new int[]{1, 6, 11, 10}));
        System.out.println(partitionSet2(new int[]{1, 6, 11, 10}));
        System.out.println(partitionSet3(new int[]{1, 6, 11, 10}));

    }
}
