package medium;

/**
 * Created by chenlijie on 8/3/17.
 */
public class Set_Matrix_Zeroes_73 {


    static void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int row = 1;
        int col = 1;

        if (matrix[0][0] == 0) {
            row = 0;
            col = 0;
        } else {
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    col = 0;
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                if (matrix[0][i] == 0) {
                    row = 0;
                    break;
                }
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row == 0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (col == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,2,3,4},
                {5,0,5,2},
                {8,9,2,0},
                {5,7,2,1}
        };

        setZeroes(grid);
    }
}
