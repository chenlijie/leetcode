package medium;

import utility.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenlijie on 11/4/17.
 */
public class Walls_and_Gates_286 {

    /**
     *
     You are given a m x n 2D grid initialized with these three possible values.

     -1 - A wall or an obstacle.
     0 - A gate.
     INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
     Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

     For example, given the 2D grid:
     INF  -1  0  INF
     INF INF INF  -1
     INF  -1 INF  -1
     0  -1 INF INF
     After running your function, the 2D grid should be:
     3  -1   0   1
     2   2   1  -1
     1  -1   2  -1
     0  -1   3   4

     */

    static int[][] dirctions = new int[][] {
            new int[] {-1, 0}, // up
            new int[] {1, 0},  // down
            new int[] {0, -1}, // left
            new int[] {0, 1}   // right
    };

    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        findShortestPath(rooms, i, j, dirctions[k], 0);
                    }
                }
            }
        }

    }

    private static void findShortestPath(int[][] rooms, int row, int col, int[] d, int path) {
        if (row + d[0] < 0 || row + d[0] >= rooms.length || col + d[1] < 0 || col + d[1] >= rooms[0].length
                || rooms[row + d[0]][col + d[1]] == 0 || rooms[row + d[0]][col + d[1]] == -1
                    || (rooms[row + d[0]][col + d[1]] != -1 && rooms[row + d[0]][col + d[1]] < path + 1)) {
            return;
        }

        rooms[row + d[0]][col + d[1]] = path + 1;

        for (int i = 0; i < 4; i++) {
            findShortestPath(rooms, row + d[0], col + d[1], dirctions[i], path + 1);
        }
    }

    public static void wallsAndGates2(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        int rows = rooms.length;
        int cols = rooms[0].length;
        int path = 0;

        while (!queue.isEmpty()) {
            path += 1;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();

                for (int j = 0; j < dirctions.length; j++) {
                    int[] next = new int[] {p[0] + dirctions[j][0], p[1] + dirctions[j][1]};
                    if (isUnVisitedDoor(rooms, next, rows, cols)) {
                        rooms[next[0]][next[1]] = path;
                        queue.add(next);
                    }       
                }
            }
        }
    }

    private static boolean isUnVisitedDoor(int[][] rooms, int[] next, int rows, int cols) {
        if (next[0] < 0 || next[0] >= rows || next[1] < 0 || next[1] >= cols) {
            return false;
        }
        return rooms[next[0]][next[1]] == Integer.MAX_VALUE;
    }


    public static void main(String[] args) {
        int[][] rooms = new int[][] {
                new int[] {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE, },
                new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                new int[] {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                new int[] {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };

        wallsAndGates2(rooms);

        Utils.printArray(rooms);
    }
}
