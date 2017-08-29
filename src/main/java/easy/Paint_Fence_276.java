package easy;

/**
 * Created by chenlijie on 8/21/17.
 */
public class Paint_Fence_276 {

//    There is a fence with n posts, each post can be painted with one of the k colors.
//    You have to paint all the posts such that no more than two adjacent fence posts have the same color.
//    Return the total number of ways you can paint the fence.

    /**
     *
     * dp[0][i] - paint same color as previous one so dp[0][i] = dp[1][i-1]
     * dp[1][i] - paint different color from previous one so dp[1][i] = dp[0][i-1] * (k-1) + dp[1][i-1] * (k-1)
     * final answer is dp[0][n] + dp[1][n]
     *
     * 0 0 1
     * 0 1 0
     * 0 1 1
     * 1 1 0
     * 1 0 1
     * 1 0 0
     *
     *
     */

    public static int numWays(int n, int k) {
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = k;

        for (int i = 1; i < n; i++) {
            int t = dp[0];
            dp[0] = dp[1];
            dp[1] = (t + dp[1]) * (k - 1);
        }

        return dp[0] + dp[1];
    }

    public static void main(String[] args) {
        System.out.println(numWays(3, 3));
    }
}
