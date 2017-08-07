package easy;

/**
 * Created by chenlijie on 8/7/17.
 */
public class Arranging_Coins_441 {

    /*

    a*(a-1)/2<n
    a*(a-1)<2*n


     */

    public static int arrangeCoins(int n) {
        int c = 1;

        while (n >= c) {
            n -= c;
            c++;
        }

        return --c;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }
}
