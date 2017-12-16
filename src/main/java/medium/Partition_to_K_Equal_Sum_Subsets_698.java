package medium;

/**
 * Created by chenlijie on 11/23/17.
 */
public class Partition_to_K_Equal_Sum_Subsets_698 {

    static boolean canPartitionKSubsets2(int[] nums, int k) {
        int sum = 0;
        for (int i : nums)
            sum += i;

        if (sum % k != 0)
            return false;

        int sub = sum/k;
        int m = nums.length+1;
        int n = (k-1)*sub+1;
        boolean[][] dp = new boolean[m][n];
        int[] seq = new int[k];
        seq[k-1] = m - 2;

        for (int i = 0; i < m; i++)
            dp[i][0] = true;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
                dp[i][j] = dp[i][j] || dp[i-1][j];

                if (j%sub == 0 && seq[j/sub] == 0 && dp[i][j]) {
                    seq[j/sub] = i;
                }
            }
        }

        for (int i = 0; i < seq.length-1; i++) {
            if (seq[i] >= seq[i+1])
                return false;
        }

        return true;
    }

    static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums)
            sum += i;

        if (sum % k != 0)
            return false;

        return canPartition(nums, 0, 0, 0, k, new boolean[nums.length], sum / k);
    }

    static boolean canPartition(int[] nums, int start, int curSum, int curNum, int k, boolean[] used, int target) {

        if (k == 1) {
            return true;
        }
        if (curSum == target && curNum > 0) {
            return canPartition(nums, 0, 0, 0, k - 1, used, target);
        }

        if (curSum > target) {
            return false;
        }

        for (int i = start; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (canPartition(nums, i+1, curSum + nums[i], curNum++, k, used, target)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean can = canPartitionKSubsets(new int[]{1, 1},2);
        System.out.println(can);

        System.out.println(Integer.MAX_VALUE);

        int num = 11;
        num >>= 1;
        System.out.println(num);
    }
}
