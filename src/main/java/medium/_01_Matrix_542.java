package medium;

/**
 * Created by chenlijie on 11/15/17.
 */
public class _01_Matrix_542 {

    public int[][] updateMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
//                    matrix[i][j] = findNearZero(matrix, i, j);
                }
            }
        }

        return null;
    }
}
