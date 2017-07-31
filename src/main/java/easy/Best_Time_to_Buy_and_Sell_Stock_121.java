package easy;

/**
 * Created by chenlijie on 5/25/17.
 */
public class Best_Time_to_Buy_and_Sell_Stock_121 {

    public static int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int minBuy = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i]-minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }

        return maxProfit > 0 ? maxProfit : 0;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{3, 7, 1, 1, 1}));
    }
}
