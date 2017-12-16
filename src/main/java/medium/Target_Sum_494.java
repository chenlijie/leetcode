package medium;

import utility.Utils;

/**
 * Created by chenlijie on 8/19/17.
 */
public class Target_Sum_494 {



    public static int findTargetSumWays2(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public static int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

    static int findTargetSumWays(int[] nums, int S) {
        if (nums == null) { return 0; }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S < -sum || S > sum) { return 0;}
        int n = nums.length;
        int[][] f = new int[n + 1][2 * sum + 1];
        f[0][0 + sum] = 1;//It seems like make no sense, but it is the base value;
        for (int i = 1; i < n + 1; i++) {
            //Option 1: easy to understand
            for (int j = 0; j < 2 * sum + 1; j++) {
                //f[i][j] = f[i - 1][j - nums[i - 1]] + f[i - 1][j + nums[i - 1]];
                if (j - nums[i - 1] >= 0) {
                    f[i][j] += f[i - 1][j - nums[i - 1]];
                }
                if (j + nums[i - 1] <= 2 * sum) {
                    f[i][j] += f[i - 1][j + nums[i - 1]];
                }
            }

            /*//Option 2: efficient but we should think in a reverse way
            for (int j = nums[i - 1]; j < 2 * sum + 1 - nums[i - 1]; j++) {
            //for (int j = 0; j < 2 * sum + 1; j++) {//It also works
                /*if (f[i - 1][j] > 0) {
                    //the trick is we should do calculation in a reverse way:
                    //add f[i - 1][j] to f[i - 1][j +/- nums[i - 1]] only when f[i - 1][j] != 0
                    f[i][j - nums[i - 1]] += f[i - 1][j];
                    f[i][j + nums[i - 1]] += f[i - 1][j];
                }*/
        }
        Utils.printArray(f);
        return f[n][sum + S];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(findTargetSumWays(new int[]{2,20,24,38,44,21,45,48,30,48,14,9,21,10,46,46,12,48,12,38}, 48));
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
