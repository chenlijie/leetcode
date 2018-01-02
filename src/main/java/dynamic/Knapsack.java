package dynamic;

/**
 * Created by chenlijie on 1/1/18.
 */
public class Knapsack {

    /**
     * dp[i][j] : the max value if select first i item and the total
     *            weight is no more than j
     *
     * dp[i][j] = max {dp[i-1][j], dp[i-1][j-w[i] + v[i]} j >= w[i]
     *
     */

    /**
     * @param w weight array
     * @param v value array
     * @param t total weight knapsack can hold
     * @return
     */
    static int getMostValues(int[] w, int[] v, int t) {
        int len = w.length;
        int[][] dp = new int[len + 1][t + 1];


        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= t; j++) {
                if (j >= w[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]] + v[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }

        }
        System.out.println(dp[len][t]);
        return dp[len][t];
    }

    static int getMostValues2(int[] w, int[] v, int t) {
        int len = w.length;
        int[][] dp = new int[2][t + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= t; j++) {
                if (j >= w[i-1]) {
                    dp[1][j] = Math.max(dp[0][j], dp[0][j-w[i-1]] + v[i-1]);
                }
            }
            int[] x = dp[0];
            dp[0] = dp[1];
            dp[1] = x;
        }
        System.out.println(dp[0][t]);
        return dp[0][t];
    }

    public static void main(String[] args) {
        int[] w = new int[] {2,2,6,5,4};
        int[] v = new int[] {6,3,5,4,6};
        int t = 10;
        getMostValues(w, v, t);
        getMostValues2(w, v, t);
    }
}
