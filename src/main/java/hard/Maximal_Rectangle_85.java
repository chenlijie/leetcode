package hard;

/**
 * Created by chenlijie on 1/2/18.
 */
public class Maximal_Rectangle_85 {

    static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        //wh[0] : width; wh[1] : height
        int[][][] wh = new int[2][2][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    wh[0][1][j] = 0;
                    wh[1][1][j] = 0;
                } else if (i == 0 && j == 0) {
                    wh[0][1][j] = matrix[i][j];
                    wh[1][1][j] = matrix[i][j];
                } else if (i == 0 || matrix[i-1][j] == 0) {
                    wh[0][1][j] = matrix[i][j] + wh[0][1][j-1];
                    wh[1][1][j] = matrix[i][j];
                } else if (j == 0 || matrix[i][j-1] == 0) {
                    wh[0][1][j] = matrix[i][j];
                    wh[1][1][j] = matrix[i][j] + wh[1][0][j];
                } else {
                    wh[0][1][j] = Math.min(wh[0][1][j-1] + 1, wh[0][0][j]);
                    wh[1][1][j] = Math.min(wh[1][0][j] + 1, wh[1][1][j-1]);
                }

                max = Math.max(max, wh[0][1][j]*wh[1][1][j]);
                int[] t = wh[0][0];
                wh[0][0] = wh[0][1];
                wh[0][1] = t;

                t = wh[1][0];
                wh[1][0] = wh[1][1];
                wh[1][1] = t;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 1},
                {1, 0}
        };

    }
}
