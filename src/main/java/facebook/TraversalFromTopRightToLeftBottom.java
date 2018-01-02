package facebook;

import utility.Utils;

/**
 * Created by chenlijie on 12/18/17.
 */
public class TraversalFromTopRightToLeftBottom {

    static int[] traversal(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m*n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            int r = 0;
            int c = i;
            while (c >= 0) {
                ans[idx++] = matrix[r][c];
                r++;
                c--;
            }
        }

        for (int i = 1; i < m; i++) {
            int r = i;
            int c = n-1;
            while (r < m) {
                ans[idx++] = matrix[r][c];
                r++;
                c--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12},
                {13,14,15,16},
        };

        matrix = new int[0][0];

        Utils.printArray(traversal(matrix));
    }
}
