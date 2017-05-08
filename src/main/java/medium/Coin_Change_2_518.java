package medium;

/**
 * Created by chenlijie on 3/21/17.
 */
public class Coin_Change_2_518 {

    public static int change(int amount, int[] coins) {
        int temp = amount;
        int last = coins.length - 1;
        for (int i = last; i >= 0; i--) {
            temp = temp%coins[i];
        }

        if (temp == 0) {


//            return 1 + change();
        }

        return last;
    }
}
