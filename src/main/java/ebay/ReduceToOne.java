package ebay;

import java.util.Arrays;

public class ReduceToOne {

//    givin number N, get the minumun steps to reduce N to 1,
//    有效的operation是subtract by 1, div by 2, div by 3，能被2或3整除时才能用除法

    //bottom-up
    static int getMinStep(int n) {
        if (n < 1)
            return -1;

        int[] dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        return dp[n];
    }

    //top-down
    static int minStep(int n) {
        if (n < 1)
            return -1;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 0;

        return search(n, dp);
    }

    static int search(int n, int[] dp) {
        if (dp[n] != -1)
            return dp[n];

        int step = search(n - 1, dp);

        if (n % 2 == 0)
            step = Math.min(step, search(n / 2, dp));

        if (n % 3 == 0)
            step = Math.min(step, search(n / 3, dp));

        dp[n] = step + 1;
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minStep(10));
        System.out.println(getMinStep(10));
    }
}
