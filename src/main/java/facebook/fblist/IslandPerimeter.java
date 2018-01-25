package facebook.fblist;

import java.util.Map;

public class IslandPerimeter {

//    贰佰和肆佰陆拾叁的综合：给定条件与前者相同，但不找个数了，要找出周长最大的岛的周长

    int maxPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int cnt = dfs(grid, i, j, m, n, visited);
                    System.out.println(cnt);
                    max = Math.max(max, cnt);
                }
            }
        }

        return max;
    }

    int dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 1;
        }

        if (visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int cnt = 0;
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            cnt += dfs(grid, x, y, m, n, visited);
        }

        return cnt;
    }

    public static void main(String[] args) {
        IslandPerimeter p = new IslandPerimeter();
        int[][] grid = new int[][] {
//                {0,1,0,0,1},
//                {0,1,1,0,1},
//                {0,0,0,0,0},
//                {0,1,1,1,1},
//                {0,0,0,0,0},
//                {0,1,1,1,0},
//                {0,1,0,1,0},
//                {0,1,1,1,0},
//                {0,0,0,1,0},
                {}
        };

        System.out.println("max = " + p.maxPerimeter(grid));
    }
}
