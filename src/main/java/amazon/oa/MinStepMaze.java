package amazon.oa;

import javafx.geometry.Pos;

import java.util.*;

public class MinStepMaze {

    static int minStep(int[][] maze, int[] exit) {
        int[][] dxy = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

        int[] start = new int[]{0, 0};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        Map<Integer, Set<Integer>> visited = new HashMap<>();
        visited.put(0, new HashSet<>());
        visited.get(0).add(0);

        int m = maze.length;
        int n = maze[0].length;

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == exit[0] && cur[1] == exit[1])
                    return step;

                for (int[] d : dxy) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];

                    if (x >= 0 && x < m && y >= 0 && y < n
                            && maze[x][y] == 0
                            && (!visited.containsKey(x) || !visited.get(x).contains(y))) {
                        q.offer(new int[]{x, y});
                        visited.putIfAbsent(x, new HashSet<>());
                        visited.get(x).add(y);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][] {
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
        };

        System.out.println(minStep(maze, new int[] {2, 3}));
    }
}
