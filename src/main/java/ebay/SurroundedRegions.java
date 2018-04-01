package ebay;

import java.util.*;

public class SurroundedRegions {
    class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0) return;

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Queue<Pos> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                map.putIfAbsent(i, new HashSet<>());
                map.get(i).add(0);
                q.offer(new Pos(i, 0));
            }

            if (board[i][n-1] == 'O') {
                map.putIfAbsent(i, new HashSet<>());
                map.get(i).add(n-1);
                q.offer(new Pos(i, n-1));
            }

        }

        for (int i = 1; i < n-1; i++) {
            if (board[0][i] == 'O') {
                map.putIfAbsent(0, new HashSet<>());
                map.get(0).add(i);
                q.offer(new Pos(0, i));
            }

            if (board[m-1][i] == 'O') {
                map.putIfAbsent(m-1, new HashSet<>());
                map.get(m-1).add(i);
                q.offer(new Pos(m-1, i));
            }

        }

        int[][] dirc = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            Pos v = q.poll();

            for (int[] d : dirc) {
                int x = v.x + d[0];
                int y = v.y + d[1];

                if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O' && (!map.containsKey(x) || !map.get(x).contains(y))) {
                    map.putIfAbsent(x, new HashSet<>());
                    map.get(x).add(y);
                    q.offer(new Pos(x, y));
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!map.containsKey(i) || !map.get(i).contains(j))
                    board[i][j] = 'X';
            }
        }

    }

    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        sr.solve(new char[][] {
                {'O','O'},
                {'O','O'},
        });
    }
}
