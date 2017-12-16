package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 11/15/17.
 */
public class Pacific_Atlantic_Water_Flow_417 {

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        flowTo(matrix, pacific, 0, 0);
        flowTo(matrix, atlantic, n-1, m-1);

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    void flowTo(int[][] matrix, boolean[][] canFlow, int s, int t) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            flowFrom(matrix, i, s, m, n, Integer.MIN_VALUE, canFlow);
        }

        for (int i = 0; i < n; i++) {
            flowFrom(matrix, t, i, m, n, Integer.MIN_VALUE, canFlow);
        }
    }

    int[][] dirs = new int[][] { {0,1}, {0,-1}, {1,0}, {-1,0}};

    void flowFrom(int[][] matrix, int i, int j, int m, int n, int h, boolean[][] canFlow) {
        if (i < 0 || i >=m || j < 0 || j >= n || matrix[i][j] < h || canFlow[i][j])
            return;

        canFlow[i][j] = true;
        for (int[] d : dirs) {
            flowFrom(matrix, i+d[0], j+d[1], m, n, matrix[i][j], canFlow);
        }
    }

    public static void main(String[] args) {
        Pacific_Atlantic_Water_Flow_417 p = new Pacific_Atlantic_Water_Flow_417();
        int[][] water = new int[][] {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        System.out.println(p.pacificAtlantic(water));
    }
}
