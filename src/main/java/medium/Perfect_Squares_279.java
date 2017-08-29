package medium;

/**
 * Created by chenlijie on 8/22/17.
 */
public class Perfect_Squares_279 {

    /*
    1 4 9 16 25 36 49
    51 = 16 + 25
    dp[51] = dp[16] + dp[25] = 1 + 1 = 2
           = dp[50] + dp[1] = 2 + 1 = 2


    dp[50] = dp[49] + dp[1] = 1 + 1 = 2

    dp[i] = 1 if pow(n, 2) == i, else min { dp[i-1]+dp[1], dp[i-2]+dp[2] ... dp[i-j-1][j+1], dp[i-j][j] }  (i-j >= j, j>=1)

     */

    public static int numSquares(int n) {

        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            double d = i;
            int t = (int)Math.sqrt(d);

            if ((int)Math.pow(t, 2) == i) {
                dp[i] = 1;
            } else {
                int min = i;
                int j = i - 1;

                while (i >= j && j >= i/2) {
                    min = Math.min(dp[j]+dp[i-j], min);
                    j--;
                }
                dp[i] = min;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
}
