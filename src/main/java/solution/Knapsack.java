package solution;

/**
 * Created by chenlijie on 8/28/17.
 */
public class Knapsack {


    //f[i, j] = max { f[i-1, j-Wi]+Pi (j>=Wi), f[i-1, j]}
    public static int maxValue(int[] values, int[] weights, int packWeight) {

        int[][] dp = new int[values.length+1][packWeight+1];

        for (int i = 1; i <= values.length; i++) {

            for (int j = 1; j <= packWeight; j++) {
                if (j >= weights[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j-weights[i-1]]+values[i-1], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        return dp[values.length][packWeight];
    }


    public static void main(String[] args) {
        System.out.println(maxValue(new int[]{6,4,5,3,6}, new int[]{4,5,6,2,2}, 10));
    }
}
