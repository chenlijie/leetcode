package medium;

/**
 * Created by chenlijie on 7/25/17.
 */
public class Rotate_Image_48 {

    public static void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int len = matrix.length;
        int top = 0;
        int bottom = len-1;

        while (top < bottom) {
            for (int i = 0; i < len; i++) {
                int t = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = t;
            }

            top++;
            bottom--;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[][] matrix = new int[k][k];

        int s = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                matrix[i][j] = s++;
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        rotate(matrix);

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
