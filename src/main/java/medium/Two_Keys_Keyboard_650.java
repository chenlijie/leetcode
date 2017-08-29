package medium;

/**
 * Created by chenlijie on 8/24/17.
 */
public class Two_Keys_Keyboard_650 {

    public static int minSteps(int n) {

        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {

            if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = i;
                for (int j = 2; j <= i/2; j++) {
                    if (i % j == 0) {
                        dp[i] = Math.min(dp[j] + (i/j), dp[i]);
                    }
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minSteps(12));
    }
}
