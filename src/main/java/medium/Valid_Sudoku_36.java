package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenlijie on 9/12/17.
 */
public class Valid_Sudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] blocks = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            blocks[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val != '.' && (!rows[i].add(val) || !columns[j].add(val) || !blocks[i/3 + j/3*3].add(val))) {
                  return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "..4...63.",
                ".........",
                "5......9.",
                "....6....",
                "4.3.....1",
                "...7.....",
                "...5.....",
                ".........",
                ".........");

        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                board[i][j] = list.get(i).charAt(j);
            }
        }

        System.out.println(new Valid_Sudoku_36().isValidSudoku(board));
    }
}
