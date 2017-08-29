package easy;

/**
 * Created by chenlijie on 8/21/17.
 */
public class Paint_House_256 {


//    There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
//    The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
//
//    The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
//    For example,costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green,
//    and so on... Find the minimum cost to paint all houses.
//
//    Note:
//    All costs are positive integers.

    /**
     *
     * dp[0][j] : minimum cost if paint red
     * dp[1][j] : minimum cost if paint blue
     * dp[2][j] : minimum cost if paint green
     *
     * dp[0][j] = dp[0][j-1] + min(dp[1][j-1], dp[2][j-1])
     *
     */

    public static int minCostII(int [][] costs) {
        int[] dp = new int[3];

        dp[0] = costs[0][0];
        dp[1] = costs[1][0];
        dp[2] = costs[2][0];

        int t1;
        int t2;

        for (int i = 1; i < costs[0].length; i++) {
            t1 = dp[0];
            t2 = dp[1];

            dp[0] = costs[0][i] + Math.min(t2, dp[2]);
            dp[1] = costs[1][i] + Math.min(t1, dp[2]);
            dp[2] = costs[2][i] + Math.min(t1, t2);

        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    public static void main(String[] args) {
        int[][] costs = new int[][] {
                {1, 2, 4, 1},
                {3, 4, 4, 5},
                {1, 2, 1, 1}
        };

        System.out.println(minCostII(costs));
    }
}
