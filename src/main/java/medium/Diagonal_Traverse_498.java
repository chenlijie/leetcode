package medium;

import utility.Utils;

/**
 * Created by chenlijie on 12/17/17.
 */
public class Diagonal_Traverse_498 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m*n];
        visit(matrix, 0, 0, true, m-1, n-1, ans, 0);
        return ans;
    }

    void visit(int[][] matrix, int r, int c, boolean up, int m, int n, int[] ans, int i) {
        if (r < 0 || c < 0 || r > m || c > n)
            return;

        ans[i] = matrix[r][c];

        if (matrix[r][c] == 4403)
        System.out.println(matrix[r][c]);

        if (r == m && c == 0 && up) {
            visit(matrix, r-1, c+1, true, m, n, ans, i+1);
        } else if (r == 0 && c == n && !up) {
            visit(matrix, r+1, c-1, false, m, n, ans, i+1);
        } else if (r == 0 && c != n && up) {
            visit(matrix, r, c+1, false, m, n, ans, i+1);
        } else if (c == 0 && r != m && !up) {
            visit(matrix, r+1, c, true, m, n, ans, i+1);
        } else if (r == m && !up) {
            visit(matrix, r, c+1, true, m, n, ans, i+1);
        } else if (c == n && up) {
            visit(matrix, r+1, c, false, m, n, ans, i+1);
        } else if (up) {
            visit(matrix, r-1, c+1, true, m, n, ans, i+1);
        } else {
            visit(matrix, r+1, c-1, false, m, n, ans, i+1);
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][] {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9,10,11,12},
//                {13,14,15,16},
//        };

        int[][] matrix = new int[10000][1];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = i + 1;
        }
        Diagonal_Traverse_498 t = new Diagonal_Traverse_498();
        int[] a = t.findDiagonalOrder(matrix);
        Utils.printArray(a);
    }
}
