package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenlijie on 1/5/18.
 */
public class The_Maze_II_505 {

    static class Point {
        int x;
        int y;
        int d;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] ds = new int[][] { {1,0}, {-1,0}, {0,1}, {0,-1}};

        int m = maze.length;
        int n = maze[0].length;
        Point[][] points = new Point[m][n];

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         points[i][j] = new Point(i, j);
        //     }
        // }

        Point p = new Point(start[0], start[1]);

        Queue<Point> queue = new LinkedList<>();
        queue.offer(p);

        int steps = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.x == destination[0] && cur.y == destination[1])
                return cur.d;

            for (int[] d : ds) {
                int x = cur.x;
                int y = cur.y;
                int dis = cur.d;

                while (isVaild(x, y, m, n, maze)) {
                    x += d[0];
                    y += d[1];
                    dis++;
                }

                x -= d[0];
                y -= d[1];
                dis--;

                if (points[x][y] == null) {
                    p = new Point(x, y);
                    p.d = dis;
                    queue.offer(p);
                }
            }
        }

        return -1;
    }

    boolean isVaild(int x, int y, int m, int n, int[][] maze) {
        if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] != 0)
            return false;
        return true;
    }
}
