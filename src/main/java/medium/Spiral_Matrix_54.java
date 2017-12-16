package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 4/25/17.
 */
public class Spiral_Matrix_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();

        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        spiralOrder(matrix, spiral, 0, matrix.length, 0, matrix[0].length);

        return spiral;
    }

    private void spiralOrder(int[][] matrix, List<Integer> spiral, int rowS, int rowE, int columnS, int columnE) {

        if (spiral.size() == matrix.length*matrix[0].length) {
            return;
        }

        for (int i = columnS; i < columnE-1; i++) {
            spiral.add(matrix[rowS][i]);
        }

        for (int i = rowS; i < rowE-1; i++) {
            spiral.add(matrix[i][columnE-1]);
        }

        for (int i = columnE-1; i > columnS; i--) {
            spiral.add(matrix[rowE-1][i]);
        }

        for (int i = rowE-1; i > rowS; i--) {
            spiral.add(matrix[i][columnS]);
        }

        spiralOrder(matrix, spiral, ++rowS, --rowE, ++columnS, --columnE);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1},
            {4},
            {7}
        };

        for (int i : new Spiral_Matrix_54().spiralOrder(matrix)) {
            System.out.print(i + " ");
        }
    }
}
