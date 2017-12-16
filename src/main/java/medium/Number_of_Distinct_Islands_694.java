package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenlijie on 11/13/17.
 */
public class Number_of_Distinct_Islands_694 {

    static int count(int[][] grid) {

        Set<List<Integer>> islands = new HashSet<>();

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> island = new ArrayList<>();
                    helper(grid, i, j, i, j, rows, cols, island);
                    islands.add(island);
                }
            }
        }

        return islands.size();
    }

    static int[][] direct = new int[][] {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    static void helper(int[][] grid, int i, int j, int x, int y, int rows, int cols, List<Integer> island) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1) {
            return;
        }

        grid[i][j] *= -1;
        island.add(i - x);
        island.add(j - y);
        for (int[] d : direct) {
            helper(grid, i+d[0], j+d[1], x, y, rows, cols, island);
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 1, 0, 1}
        };

        System.out.println(count(grid));
    }
}
