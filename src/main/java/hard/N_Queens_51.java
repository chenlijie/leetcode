package hard;

import java.util.*;

/**
 * Created by chenlijie on 12/30/17.
 */
public class N_Queens_51 {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        List<List<String>> ans = new ArrayList<>();
        backTracking(board, 0, n, ans);
        return ans;
    }

    void backTracking(char[][] board, int r, int n, List<List<String>> ans) {
        if (r == n) {
            ans.add(generateNQueue(board));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (canPlaceQueen(board, r, i)) {
                board[r][i] = 'Q';
                backTracking(board, r + 1, n, ans);
                board[r][i] = '.';
            }
        }
    }

    boolean canPlaceQueen(char[][] board, int i, int j) {
        int n = board.length;
        int[][] dirc = new int[][] { {0, -1}, {-1, 0}, {-1, -1}, {-1, 1} };
        for (int[] d : dirc) {
            if (findQueen(board, i, j, d[0], d[1], n))
                return false;
        }

        return true;
    }

    boolean findQueen(char[][] board, int i, int j, int x, int y, int n) {
        if (i+x < 0 || i+x >= n || j+y < 0 || j+y >= n)
            return false;

        if (board[i+x][j+y] == 'Q')
            return true;
        else
            return findQueen(board, i+x, j+y, x, y, n);
    }

    List<String> generateNQueue(char[][] board) {
        int n = board.length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                builder.append(board[i][j]);
            }
            res.add(builder.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        N_Queens_51 q = new N_Queens_51();
        System.out.println(q.solveNQueens(4));

        List<Integer> list = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        list = queue;
    }
}
