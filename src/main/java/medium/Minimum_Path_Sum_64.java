package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 8/13/17.
 */
public class Minimum_Path_Sum_64 {

    //s[i][j] = min(s[i-1][j], s[i][j-1]) + g[i][j]
    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int[][] sums = new int[grid.length][grid[0].length];
        sums[0][0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    sums[i][j] = grid[0][0];
                } else if (i == 0) {
                    sums[i][j] = sums[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    sums[i][j] = sums[i-1][j] + grid[i][j];
                } else {
                    sums[i][j] = Math.min(sums[i][j-1], sums[i-1][j]) + grid[i][j];
                }
            }
        }

        return sums[grid.length-1][grid[0].length-1];

    }

    public static int minPathSum2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int rowLen = grid.length;
        int columnLen = grid[0].length;

        boolean[][] visited = new boolean[rowLen][columnLen];
        int[][] pathSums = new int[rowLen][columnLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < columnLen; j++) {
                pathSums[i][j] = -1;
            }
        }
        pathSums[0][0] = grid[0][0];

        Map<String, Integer> candidates = new HashMap<>();
        candidates.put("0,0", pathSums[0][0]);

        int r = 0;
        int c = 0;

        int min;

        while (true) {

            min = Integer.MAX_VALUE;
            //find candidate
            for (String key : candidates.keySet()) {
                if (candidates.get(key) < min) {
                    min = candidates.get(key);
                    r = Integer.valueOf(key.split(",")[0]);
                    c = Integer.valueOf(key.split(",")[1]);
                }
            }

            if (candidates.get(r + "," + c).equals(candidates.get((rowLen - 1) + "," + (columnLen - 1)))) {
                r = rowLen - 1;
                c = columnLen - 1;
            }

            if (r == rowLen-1 && c == columnLen-1) {
                break;
            }

            //go right
            if (c + 1 < columnLen && !visited[r][c + 1]) {

                if (pathSums[r][c + 1] == -1 || (pathSums[r][c] + grid[r][c + 1]) < pathSums[r][c + 1]) {
                    pathSums[r][c + 1] = pathSums[r][c] + grid[r][c + 1];
                }
                candidates.put(r + "," + (c + 1), pathSums[r][c + 1]);
            }

            //go down
            if (r + 1 < rowLen && !visited[r + 1][c]) {

                if (pathSums[r + 1][c] == -1 || (pathSums[r][c] + grid[r + 1][c]) < pathSums[r + 1][c]) {
                    pathSums[r + 1][c] = pathSums[r][c] + grid[r + 1][c];
                }
                candidates.put((r + 1) + "," + c, pathSums[r + 1][c]);
            }

            visited[r][c] = true;
            candidates.remove(r + "," + c);
        }

        return pathSums[r][c];
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][] {
//                {1, 100, 1, 1,   1},
//                {1, 1,   1, 1,   1},
//                {1, 100, 1, 100, 1},
//                {1, 100, 1, 100, 1},
//                {1, 100, 1, 100, 1}
//        };
        int[][] grid = new int[][] {
                {4,20,90,6,0,3,1},
                {1,80,90,8,0,3,0},
                {0,0,5,1,7,4,6}
        };
        System.out.println(minPathSum(grid));
    }

}
