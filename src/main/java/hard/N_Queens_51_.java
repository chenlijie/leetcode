package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by chenlijie on 12/30/17.
 */
public class N_Queens_51_ {

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        List<Integer> queens = new ArrayList<>();
        backTracking(board, 0, n, ans, queens);
        return ans;
    }

    void backTracking(int[][] board, int r, int n, List<List<String>> ans, List<Integer> queens) {
        if (r == n) {
            ans.add(generateNQueue(queens, n));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (canPlace(board, r, i)) {
                queens.add(i);
                markCell(board, r, i, n, 1);
                backTracking(board, r + 1, n, ans, queens);
                markCell(board, r, i, n, -1);
                queens.remove(queens.size() - 1);
            }
        }
    }

    boolean canPlace(int[][] board, int i, int j) {
        return board[i][j] == 0;
    }

    void markCell(int[][] board, int i, int j, int n, int offset) {
        for (int k = 0; k < n; k++) {
            board[i][k] += offset;
            board[k][j] += offset;
        }
        board[i][j] -= 1;
        markDiagonalCell(board, i, j, -1, -1, n, offset);
        markDiagonalCell(board, i, j, 1, 1, n, offset);
        markDiagonalCell(board, i, j, -1, 1, n, offset);
        markDiagonalCell(board, i, j, 1, -1, n, offset);
    }

    void markDiagonalCell(int[][] board, int i, int j, int x, int y, int n, int offset) {
        if (i+x < 0 || i+x >= n || j+y < 0 || j+y >= n)
            return;

        board[i+x][j+y] += offset;
        markDiagonalCell(board, i+x, j+y, x, y, n, offset);
    }

    List<String> generateNQueue(List<Integer> queens, int n) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int q = queens.get(i);
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (q == j) {
                    builder.append("Q");
                } else {
                    builder.append(".");
                }
            }
            res.add(builder.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        N_Queens_51_ q = new N_Queens_51_();
        System.out.println(q.solveNQueens(4));
    }
}
