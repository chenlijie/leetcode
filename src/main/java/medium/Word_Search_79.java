package medium;

/**
 * Created by chenlijie on 7/31/17.
 */
public class Word_Search_79 {

    public boolean exist(char[][] board, String word) {

        int[][] visted = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, 0, i, j, visted)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 0 - no direction, 1 - right, 2 - down, 3 - left, 4 - up
    private boolean search(char[][] board, String word, int next, int x, int y, int[][] visted) {
        if (board[x][y] != word.charAt(next)) {
            return false;
        }

        visted[x][y] = 1;

        if (word.length() == next+1) {
            return true;
        }

        //go right
        if (y+1 < board[0].length && visted[x][y+1] == 0 &&  search(board, word, next+1, x, y+1, visted)) {
            return true;
        }

        //go down
        if (x+1 < board.length && visted[x+1][y] == 0 && search(board, word, next+1, x+1, y, visted)) {
            return true;
        }

        //go left
        if (y-1 >= 0 && visted[x][y-1] == 0 && search(board, word, next+1, x, y-1, visted)) {
            return true;
        }

        //go up
        if (x-1 >= 0 && visted[x-1][y] == 0 && search(board, word, next+1, x-1, y, visted)) {
            return true;
        }
        visted[x][y] = 0;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//                {'a', 'a', 'a', 'a'},
//                {'a', 'a', 'a', 'a'},
//                {'a', 'a', 'a', 'a'}
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };




        System.out.println('A'^256);
        System.out.println(new Word_Search_79().exist(board, "AAB"));
//        System.out.println(new Word_Search_79().exist(board, "SEE"));
//        System.out.println(new Word_Search_79().exist(board, "ABCB"));
//        System.out.println(new Word_Search_79().exist(board, "ESCFBASAD"));
//        System.out.println(new Word_Search_79().exist(board, "aaaaaaaaaaaaa"));


    }
}
