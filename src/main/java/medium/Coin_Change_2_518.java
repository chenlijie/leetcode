package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by chenlijie on 3/21/17.
 */
public class Coin_Change_2_518 {

    public static int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int i = 0;
        int j = coins.length - 1;

        while (i < j) {
            int t = coins[i];
            coins[i] = coins[j];
            coins[j] = t;
            i++;
            j--;
        }

        return dfs(amount, coins, 0);
    }

    static int dfs(int amount, int[] coins, int s) {
        int sum = 0;

        for (int i = s; i < coins.length; i++) {
            if (amount > coins[i]) {
                sum += dfs(amount-coins[i], coins, i);
            } else if (amount == coins[i]) {
                sum++;
            } else {
                sum += dfs(amount, coins, i + 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[] {1,2,5}));
    }
}
