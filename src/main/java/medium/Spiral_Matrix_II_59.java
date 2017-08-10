package medium;

/**
 * Created by chenlijie on 8/8/17.
 */
public class Spiral_Matrix_II_59 {

    public static int[][] generateMatrix(int n) {

        int rowS = 0;
        int rowE = n - 1;

        int columnS = 0;
        int columnE = n - 1;

        int m = 1;
        int[][] matrix = new int[n][n];

        while (rowS <= rowE && columnS <= columnE) {

            for (int i = columnS; i <= columnE; i++) {
                matrix[rowS][i] = m++;
            }
            rowS++;

            for (int i = rowS; i <= rowE; i++) {
                matrix[i][columnE] = m++;
            }
            columnE--;

            if (columnS <= columnE) {
                for (int i = columnE; i >= columnS; i--) {
                    matrix[rowE][i] = m++;
                }
                rowE--;
            }

            if (rowS <= rowE) {
                for (int i = rowE; i >= rowS; i--) {
                    matrix[i][columnS] = m++;
                }
                columnS++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(generateMatrix(1));
    }
}
