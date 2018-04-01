package microsoft;

public class MinPathSum {

    static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n + 1];

        for (int i = 1; i <=n; i++) {
            dp[i] += dp[i - 1] + grid[0][i - 1];
        }
        dp[0] = Integer.MAX_VALUE;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j+1] = Math.min(dp[j+1], dp[j]) + grid[i][j];
            }
        }

        System.out.println(dp[n]);
        return dp[n];
    }

    public static void main(String[] args) {
        minPathSum(new int[][]{
                {1,2},
                {5,6},
                {1,1}
        });
    }
}
