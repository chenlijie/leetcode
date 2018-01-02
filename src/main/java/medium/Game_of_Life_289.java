package medium;

/**
 * Created by chenlijie on 12/29/17.
 */
public class Game_of_Life_289 {

    static void gameOfLife(int[][] board) {
        if (board.length == 0) return;

        int m = board.length;
        int n = board[0].length;
        int[][] dirc = new int[][] { {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}};

        //next state | current state
        //  0(dead)      1(live)
        //  0(dead)      0(dead)
        //  1(live)      1(live)
        //  1(live)      0(dead)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = -board[i][j];
                /*for (int[] d : dirc) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        sum += (board[x][y] & 1);
                    }
                }*/
                for (int x = Math.max(0, i-1); x <= Math.min(m-1, i+1); x++) {
                    for (int y = Math.max(0, j-1); y <= Math.min(n-1, j+1); y++) {
                        sum += (board[x][y] & 1);
                    }
                }
                if (board[i][j] == 1 && (sum == 2 || sum == 3)) {
                    board[i][j] |= 2;
                } else if (board[i][j] == 0 && sum == 3) {
                    board[i][j] |= 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }


    public static void main(String[] args) {
        gameOfLife(new int[][]{
                {1, 1},
                {1, 0}
        });
    }
}
