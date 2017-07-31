package medium;

/**
 * Created by chenlijie on 7/24/17.
 */
public class Search_a_2D_Matrix_II_240 {

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    break;
                }
            }
        }

        return false;
    }
}
