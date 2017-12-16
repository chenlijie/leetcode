package medium;

/**
 * Created by chenlijie on 7/31/17.
 */
public class Number_of_Islands_200 {

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                count += traversal(grid, visited, i, j);
            }
        }
        return count;
    }

    private int traversal(char[][] grid, boolean[][] visited, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] ||grid[i][j] == '0') {
            return 0;
        }
        visited[i][j] = true;

        traversal(grid, visited, i+1, j);
        traversal(grid, visited, i-1, j);
        traversal(grid, visited, i, j+1);
        traversal(grid, visited, i, j-1);
        return 1;
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    count++;
                    mark(grid, i, j);
                }
            }
        }

        return count;
    }

    void mark(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '1') {
            return;
        }

        grid[i][j] = '1';
        mark(grid, i-1, j);
        mark(grid, i+1, j);
        mark(grid, i, j-1);
        mark(grid, i, j+1);
    }

    public static void main(String[] args) {
        char[][] map = new char[][]{
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        map = new char[0][0];
        System.out.println(new Number_of_Islands_200().numIslands(map));
    }
}
