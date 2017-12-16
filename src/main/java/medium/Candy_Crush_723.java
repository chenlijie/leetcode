package medium;

import utility.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 11/18/17.
 */
public class Candy_Crush_723 {

    int[][] candyCrush(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        boolean find = true;
        
        while (find) {
            find = false;

            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 0 && !visited[i][j]) {
                        List<int[]> pos = new ArrayList<>();
                        helper(board, visited, board[i][j], i, j, m, n, pos);

                        if (pos.size() >= 3) {
                            eliminate(board, pos);
                            find = true;
                        } 
                    }
                }
            }

            restore(board);
        }
        
        return board;
    }

    void restore(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < n; i++) {
            restoreCol(board, i, m - 1);
        }
    }

    void restoreCol(int[][] board, int col, int end) {
        int i = end;
        int j = end;

        while (i >= 0) {
            while (i >= 0 && board[i][col] != 0) {
                i--;
            }

            j = i-1;
            while (j >= 0 && board[j][col] == 0) {
                j--;
            }

            if (j >= 0) {
                swap(board, col, i, j);
            }
            i--;
        }
    }

    void swap(int[][] board, int col, int i, int j) {
        int t = board[i][col];
        board[i][col] = board[j][col];
        board[j][col] = t;
    }

    void eliminate(int[][] board, List<int[]> pos) {
        for (int[] p : pos) {
            board[p[0]][p[1]] = 0;
        }
    }

    void helper(int[][] board, boolean[][] visited, int val, int i, int j, int m, int n, List<int[]> pos) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != val || visited[i][j])
            return;
        
        pos.add(new int[]{i, j});
        visited[i][j] = true;
        helper(board, visited, val, i+1, j, m, n, pos);
        helper(board, visited, val, i-1, j, m, n, pos);
        helper(board, visited, val, i, j+1, m, n, pos);
        helper(board, visited, val, i, j-1, m, n, pos);
    }

    public static void main(String[] args) {
        Candy_Crush_723 c = new Candy_Crush_723();
        int[][] board = new int[][] {
                {8, 8, 3, 7},
                {1, 1, 1, 3},
                {2, 8, 8, 4},
                {2, 2, 2, 2},
        };

        c.candyCrush(board);

        Utils.printArray(board);
    }
}
