package microsoft.onsite;

public class PossibleSum {

    static void possibleSum(int[] nums, int t) {
        boolean p = helper(nums, 0, t);
        System.out.println(p);
    }

    static boolean helper(int[] nums, int start, int remain) {
        if (remain == 0)
            return true;

        if (start == nums.length)
            return false;


        for (int i = start; i < nums.length; i++) {
            if (helper(nums, i + 1, remain - nums[i]))
                return true;
        }

        return false;
    }

    static void possibleSum_2(int[] nums, int t) {
        int min = 0;
        int max = 0;
        for (int n : nums) {
            if (n < 0)
                min += n;
            else
                max += n;
        }

        if (max < t)
            System.out.println(false);

        boolean[] dp = new boolean[t - min + 2];
        dp[0] = true;

        for (int i = min + 1; i <= t; i++) {

            for (int j = 0; j < nums.length; j++) {
                dp[i - min] = dp[i - min] ||  (i - min - nums[j] >= 0 && i - min - nums[j] <= t && dp[i - min - nums[j]]);
            }
        }

        System.out.println(dp[t - min + 1]);
    }

    public static void main(String[] args) {
        possibleSum(new int[] {2, -6, 5, -1, 2}, 2);
        possibleSum_2(new int[] {2, -6, 5, -1, 2}, 2);
    }
}
