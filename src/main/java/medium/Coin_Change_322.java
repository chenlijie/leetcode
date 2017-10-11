package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 5/23/17.
 */
public class Coin_Change_322 {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    if (dp[i] != -1 && dp[i - coins[j]] != -1) {
                        dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                    } else if (dp[i] == -1 && dp[i - coins[j]] != -1) {
                        dp[i] = dp[i-coins[j]]+1;
                    }
                }
            }
        }

        return dp[amount];
    }


    public static void main(String[] args) {
        System.out.println(new Coin_Change_322().coinChange(new int[]{249,459,494,426,32,372,225}, 4));
//        System.out.println(new Coin_Change_322().coinChange(new int[]{1, 2, 5}, 11));

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        a.left = b;
        b = null;

    }
}
