package medium;

/**
 * Created by chenlijie on 8/19/17.
 */
public class Target_Sum_494 {



    public static int findTargetSumWays(int[] nums, int s) {
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

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(findTargetSumWays(new int[]{2,20,24,38,44,21,45,48,30,48,14,9,21,10,46,46,12,48,12,38}, 48));
        System.out.println(findTargetSumWays(new int[]{2, 2, 3, 4}, 3));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
