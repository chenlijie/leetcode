package facebook.fblist;

import java.util.*;

public class ShortestPathFromLeftToRight {

    static int shortestPath(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 'O') {
                queue.offer(new int[] {i, 0});
                visited.add(i + "," + 0);
            }
        }

        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        int level = 0;

        while (!queue.isEmpty()) {

            level++;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();

                if (pos[1] == n-1) {
                    System.out.println("shortest path is " + level);
                    return level;
                }

                for (int j = 0; j < 4; j++) {
                    int x = pos[0] + dx[j];
                    int y = pos[1] + dy[j];

                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (grid[x][y] == 'O' && !visited.contains(x + "," + y)) {
                            queue.offer(new int[] {x, y});
                            visited.add(x + "," + y);
                        }
                    }
                }
            }
        }

        return -1;
    }

    static List<int[]> theShortestPath(char[][] grid) {
        if (grid.length == 0)
            return new ArrayList<>();

        int m = grid.length;
        int n = grid[0].length;

        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        Map<int[], int[]> pathFrom = new HashMap<>();
//        Map<List<Integer>, List<Integer>> pathFrom = new HashMap<>();

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 'O') {
                queue.offer(new int[] {i, 0});
                visited.add(i + "," + 0);
            }
        }

        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};


        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();

                if (pos[1] == n-1) {
                    List<int[]> ans = new ArrayList<>();
                    ans.add(pos);

                    int[] key = pos;
                    while (pathFrom.containsKey(key)) {
                        key = pathFrom.get(key);
                        ans.add(key);
                    }

                    System.out.print("shortest path is ");
                    for (int[] p : ans) {
                        System.out.print("[" + p[0] + "," + p[1] + "],  ");
                    }
                    return ans;
                }

                for (int j = 0; j < 4; j++) {
                    int x = pos[0] + dx[j];
                    int y = pos[1] + dy[j];

                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (grid[x][y] == 'O' && !visited.contains(x + "," + y)) {
                            int[] next = new int[] {x, y};
                            queue.offer(next);
                            visited.add(x + "," + y);
                            pathFrom.put(next, pos);
                        }
                    }
                }
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        theShortestPath(new char[][]{
                {'O'}
//                {'O', 'O', 'X', 'O'},
//                {'X', 'O', 'X', 'O'},
//                {'X', 'O', 'O', 'O'},
//                {'X', 'O', 'X', 'O'}
        });
    }

}
