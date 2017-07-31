package medium;

/**
 * Created by chenlijie on 7/25/17.
 */
public class Rotate_Image_48 {

    public static void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int loop = matrix.length/2;
        int x = -1;
        int y = -1;

        for (int i = 0; i < loop; i++) {
            x++;
            y++;
            int turns = matrix.length - 1 - 2*i;

            for (int j = 0; j < turns; j++) {
                int offset = turns - j;

                int temp = matrix[x][y];

                matrix[x][y] = matrix[x-offset][y+j];
                matrix[x-offset][y+j] = matrix[x-j][y-offset];
                matrix[x-j][y-offset] = matrix[x+offset][y+j];
                matrix[x+offset][y+j] = temp;

            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int k = 2;
        int[][] matrix = new int[k][k];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                matrix[i][j] = i+j;
            }
        }
        rotate(matrix);
    }
}
