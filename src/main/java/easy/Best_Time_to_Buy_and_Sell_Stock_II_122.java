package easy;

/**
 * Created by chenlijie on 8/6/17.
 */
public class Best_Time_to_Buy_and_Sell_Stock_II_122 {


    public static int maxProfit(int[] prices) {

        boolean buy = true;
        boolean sell = true;
        int[] profits = new int[prices.length];
        int[] buyPrices = new int[prices.length];
        int[] sellPrices = new int[prices.length];

        buyPrices[0] = prices[0];

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < buyPrices[i-1] && sellPrices[i-1] == 0) {
                buyPrices[i] = prices[i];
                profits[i] = profits[i-1];
            }

            if (prices[i] > buyPrices[i-1] && prices[i] > sellPrices[i-1]) {
                buyPrices[i] = buyPrices[i-1];
                sellPrices[i] = prices[i];
                profits[i] += sellPrices[i] - sellPrices[i-1];
            }
        }

        return profits[prices.length-1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4} ));
    }

}