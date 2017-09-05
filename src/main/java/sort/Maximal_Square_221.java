package sort;

/**
 * Created by chenlijie on 8/29/17.
 */
public class Maximal_Square_221 {


    /*

        1 0 1 0 0
        1 0 1 1 1
        1 1 1 1 1
        1 0 0 1 0

        dp[i][j] = min { dp[i-1][j], dp[i][j-1], dp[i-1][j-1]} + 1

     */

    public static int maximalSquare(char[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max, dp[0][i]);
        }

        for (int i = 1; i < matrix.length; i++) {

            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max*max;
    }

    public static int maximalSquare2(char[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[m+1];
        int maxsize = 0, pre = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= m; i++) {
                int temp = dp[i];
                if (matrix[i - 1][j] == '1') {
                    dp[i] = Math.min(dp[i], Math.min(dp[i - 1], pre)) + 1;
                    maxsize = Math.max(maxsize, dp[i]);
                }
                else dp[i] = 0;
                pre = temp;

                for (int k = 0; k < dp.length; k++) {
                    System.out.print(dp[k] + "  ");
                }
                System.out.println();
                System.out.println(pre);
            }
        }
        return maxsize * maxsize;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare2(new char[][]{
                {'1','1','1'},
                {'1','1','1'},
                {'1','1','1'}
        }));
    }
}
