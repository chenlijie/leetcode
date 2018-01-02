package hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chenlijie on 1/2/18.
 */
public class Best_Time_to_Buy_and_Sell_Stock_III_123 {

    static int maxProfit2(int[] prices) {

        int m = 3;
        int len = prices.length;
        int[][] dp = new int[m][len];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < len; j++) {
                dp[i][j] = dp[i][j-1];
                for (int k = 0; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], prices[j]-prices[k] + dp[i-1][k]);
                }
            }
        }

        return dp[m-1][len-1];
    }

    static int maxProfit(int[] prices) {

        int m = 3;
        int len = prices.length;
        int[][] dp = new int[m][len];

        for (int i = 1; i < m; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < len; j++) {
                max = Math.max(max, dp[i-1][j-1] - prices[j-1]);
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + max);
            }
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = m-1, j = len-1; i > 0; i--) {
            while (j-1 >= 0 && dp[i][j] == dp[i][j-1]) j--;

            stack.push(j);

            int p = dp[i][j] - prices[j];
            while (i-1 >= 0 && dp[i-1][j] - prices[j] != p) j--;
            stack.push(j);
        }

        while (!stack.isEmpty()) {
            System.out.println("Buy on : " + stack.pop());
            System.out.println("Sell on : " + stack.pop());
        }

        return dp[m-1][len-1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));

//        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
//        System.out.println(maxProfit2(new int[]{3,3,5,0,0,3,1,4}));
    }
}
