package dynamic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenlijie on 10/22/17.
 */
public class RobotInAGrid {


    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (r != point.r) return false;
            return c == point.c;
        }

        @Override
        public int hashCode() {
            int result = r;
            result = 31 * result + c;
            return result;
        }
    }


    boolean getPath(boolean[][] maze, int r, int c, List<Point> list) {
        if (r < 0 || c < 0 || !maze[r][c]) {
            return false;
        }

        boolean isAtOrigin = r == 0 && c == 0;

        if (isAtOrigin || getPath(maze, r - 1, c, list) || getPath(maze, r, c - 1, list)) {
            list.add(new Point(r, c));
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        Set<Point> set = new HashSet<>();
        set.add(new Point(1,1));
        set.add(new Point(1,1));
        System.out.println(set.size());
    }
}
