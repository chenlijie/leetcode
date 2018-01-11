package medium;

/**
 * Created by chenlijie on 1/5/18.
 */
public class The_Maze_490 {

    static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0)
            return false;

        if (start[0] == destination[0] && start[1] == destination[1])
            return true;

        int m = maze.length;
        int n = maze[0].length;

        int x = start[0];
        int y = start[1];

        maze[x][y] = 1;

        int i = y;
        while (i + 1 < n && maze[x][i+1] == 0) i++;
        if (i != y) {
            if (hasPath(maze, new int[]{x, i}, destination)) return true;
        }

        i = y;
        while (i - 1 >= 0 && maze[x][i-1] == 0) i--;
        if (i != y) {
            if (hasPath(maze, new int[]{x, i}, destination)) return true;
        }

        i = x;
        while (i + 1 < m && maze[i+1][y] == 0) i++;
        if (i != x) {
            if (hasPath(maze, new int[]{i, y}, destination)) return true;
        }

        i = x;
        while (i - 1 >= 0 && maze[i-1][y] == 0) i--;
        if (i != x) {
            if (hasPath(maze, new int[]{i, y}, destination)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPath(new int[][]{
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        }, new int[]{0, 4}, new int[]{3, 2}));
        
    }
}
