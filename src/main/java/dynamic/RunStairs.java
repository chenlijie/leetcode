package dynamic;

/**
 * Created by chenlijie on 10/20/17.
 */
public class RunStairs {

    static int countWays(int n, int[] ways) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else if (ways[n] > -1) {
            return ways[n];
        } else {
            ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways) + countWays(n - 3, ways);
            return ways[n];
        }
    }

    public static void main(String[] args) {
        int n = 36;
        int[] dp = new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        System.out.println(countWays(n, dp));
    }
}
