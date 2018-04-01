package zillow;

import utility.Utils;

public class Fibonacci {

    //f(0) = 0, f(1) = 1
    //f(n) = f(n-1) + f(n-2)

    static int get(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int ans = helper(n, dp);

        System.out.println("ans = " + ans);
        Utils.printArray(dp);
        return ans;
    }

    static int helper(int n, int[] dp) {
        if (n <= 1)
            return dp[n];
        else if (dp[n] != 0)
            return dp[n];
        else {
            dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
            return dp[n];
        }
    }

    static int get_2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }

        Utils.printArray(dp);
        return dp[n];
    }

    static int get_3(int n) {
        int[] dp = new int[3];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i % 3] = dp[(i + 1) % 3] + dp[(i + 2) % 3];
        }

        Utils.printArray(dp);
        System.out.println("ans = " + dp[n % 3]);
        return dp[n % 3];
    }

    public static void main(String[] args) {
        get(15);
        get_2(15);
        get_3(15);
    }
}
