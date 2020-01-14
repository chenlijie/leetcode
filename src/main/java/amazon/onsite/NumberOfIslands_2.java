package amazon.onsite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_2 {

    public int find(int i, int[] parent) {
        if (parent[i] != -1)
            return find(parent[i], parent);
        return i;
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int island = 0;
        int[] parent = new int[grid.length * grid[0].length];
        int[][] dirc = new int[][] {{-1,0}, {0,-1}};
        Arrays.fill(parent, -1);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    island++;

                    int p1 = i * grid[0].length + j;

                    for (int[] d : dirc) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                            int p2 = find(x * grid[0].length + y, parent);

                            if (p1 != p2) {
                                island--;
                                parent[p2] = p1;
                            }
                        }
                    }
                }
            }
        }

        return island;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','1','1','1','1','1'},
                {'0','0','0','0','0','0','1'},
                {'1','1','1','1','1','0','1'},
                {'1','0','0','0','1','0','1'},
                {'1','0','1','0','1','0','1'},
                {'1','0','1','1','1','0','1'},
                {'1','1','1','1','1','1','1'}
        };

        int n = new NumberOfIslands_2().numIslands(grid);
        System.out.println(n);
    }
}
