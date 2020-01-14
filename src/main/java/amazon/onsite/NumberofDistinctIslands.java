package amazon.onsite;

import java.util.*;

public class NumberofDistinctIslands {


    public int numberofDistinctIslands_2(int[][] grid) {
        if (grid.length == 0) return 0;


        Set<List<Integer>> islands = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    dfs(grid, i, j, visited, i, j, list);

                    if (!list.isEmpty())
                        islands.add(list);
                }
            }
        }

        return islands.size();
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, int x, int y, List<Integer> list) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j])
            return;

        list.add(i - x);
        list.add(j - y);
        visited[i][j] = true;

        dfs(grid, i + 1, j, visited, x, y, list);
        dfs(grid, i - 1, j, visited, x, y, list);
        dfs(grid, i, j + 1, visited, x, y, list);
        dfs(grid, i, j - 1, visited, x, y, list);
    }


    static int numberofDistinctIslands(int[][] grid) {
        if (grid.length == 0) return 0;


        Set<List<Integer>> islands = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirc = new int[][] { {1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    q.add(new int[] {i, j});
                    List<Integer> list = new ArrayList<>();

                    while (!q.isEmpty()) {
                        int[] v = q.poll();
                        visited[v[0]][v[1]] = true;

                        list.add(v[0] - i);
                        list.add(v[1] - j);

                        for (int[] d : dirc) {
                            int x = v[0] + d[0];
                            int y = v[1] + d[1];

                            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !visited[x][y])
                                q.add(new int[] {x, y});
                        }
                    }

                    islands.add(list);
                }
            }
        }

        System.out.println(islands.size());
        return islands.size();
    }

    public static void main(String[] args) {
        numberofDistinctIslands(new int[][]{
                {1,1,0,0,1},
                {1,0,0,0,0},
                {1,1,0,0,1},
                {0,1,0,1,1}
        });
    }
}
