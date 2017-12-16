package hard;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chenlijie on 11/18/17.
 */
public class Shortest_Distance_from_All_Buildings_317 {

    static int shortestDistance(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dis = new int[m][n];

        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, dis, i, j, start--, m, n);
                }
            }
        }

        return min;
    }

    static int min = Integer.MAX_VALUE;
    static int[][] dirs = new int[][] { {1,0}, {-1,0}, {0,1}, {0,-1}};

    static void bfs(int[][] grid, int[][] dis, int i, int j, int start, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int level = 0;
        min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();

                for (int[] d : dirs) {
                    int d1 = cur[0] + d[0];
                    int d2 = cur[1] + d[1];

                    if (d1 >= 0 && d1 < m && d2 >= 0 && d2 < n && grid[d1][d2] == start) {
                        grid[d1][d2] -= 1;
                        dis[d1][d2] += level;
                        min = Math.min(min, dis[d1][d2]);
                        queue.offer(new int[]{d1, d2});
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };

        System.out.println(shortestDistance(grid));
    }
}
