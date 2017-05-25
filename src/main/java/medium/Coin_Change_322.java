package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 5/23/17.
 */
public class Coin_Change_322 {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        List<Integer> list = new ArrayList<>();
        int sum = coinChange(coins, amount, coins.length-1, list);
        return sum;
    }

    private int coinChange(int[] coins, int amount, int next, List<Integer> list) {
        if (next >= 0) {

            if (amount%coins[next] == 0) {
                return amount/coins[next];
            }

            int n = amount/coins[next];
            int sum;
            int min = Integer.MAX_VALUE;
            for (int i = n; i >= 0; i--) {
                sum = coinChange(coins, amount-i*coins[next], next-1, list);
                if (sum >= 0) {
                    min = Math.min(sum+i, min);
                }
            }
            return min == Integer.MAX_VALUE ? -1 : min;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Coin_Change_322().coinChange(new int[]{336,288,378,16,319,146}, 9212));
//        System.out.println(new Coin_Change_322().coinChange(new int[]{13, 7, 5, 1}, 23));
    }
}
