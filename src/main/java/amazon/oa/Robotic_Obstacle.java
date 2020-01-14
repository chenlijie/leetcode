package amazon.oa;

import java.util.*;

/**
 * 
 */
public class Robotic_Obstacle {

    public static int minDistance(int numRows, int numColumns, List<List<Integer>> area) {
        if (numRows < 2) return -1;

        boolean[][] visited = new boolean[numRows][numColumns];
        visited[0][0] = true;

        int[][] dirc = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point p = queue.poll();

                if (area.get(p.x).get(p.y) == 9) {
                    return step + 1;
                }

                for (int[] d : dirc) {
                    int x = p.x + d[0];
                    int y = p.y + d[1];

                    if (x >= 0 && x < numRows && y >= 0 && y < numColumns && !visited[x][y] && area.get(x).get(y) == 1) {
                        visited[x][y] = true;
                        queue.offer(new Point(x, y));
                    }
                }
            }

            step++;
        }

        return -1;

    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> area = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(1);list.add(1);list.add(1);
        area.add(list);

        list = new ArrayList<>();
        list.add(0);list.add(1);list.add(1);list.add(1);
        area.add(list);

        list = new ArrayList<>();
        list.add(0);list.add(1);list.add(0);list.add(1);
        area.add(list);

        list = new ArrayList<>();
        list.add(1);list.add(1);list.add(9);list.add(1);
        area.add(list);

        list = new ArrayList<>();
        list.add(0);list.add(0);list.add(1);list.add(1);
        area.add(list);

        System.out.println(minDistance(5, 4, area));

    }
}
