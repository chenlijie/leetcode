package medium;

/**
 * Created by chenlijie on 8/3/17.
 */
public class Set_Matrix_Zeroes_73 {


    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] collum = new boolean[n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    collum[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || collum[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
