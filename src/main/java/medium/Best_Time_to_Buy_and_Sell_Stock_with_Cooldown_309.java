package medium;

/**
 * Created by chenlijie on 1/2/18.
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {

    static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        sell[0] = 0;
        buy[0] = -prices[0];

        for (int i = 1; i < prices.length; ++i) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
        }
        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        maxProfit(new int[]{1,3,2,3});
        System.out.println("0123456".substring(2,5));
    }
}
