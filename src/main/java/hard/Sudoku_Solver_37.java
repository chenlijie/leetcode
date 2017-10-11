package hard;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 9/12/17.
 */
public class Sudoku_Solver_37 {

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int column) {
        if (column == 9 || row == 9) {
            return true;
        }

        //If haven't filled any number, loop from 1 to 9 to find a possible solution.
        //else it's already filled with one number and go to check next slot.
        if (board[row][column] == '.') {
            for (char j = '1'; j <= '9'; j++) {
                if (change(row, column, j, board)
                        && solve(board, row, column+1)
                            && solve(board, row+1, 0)) {
                    return true;
                }
                board[row][column] = '.';
            }
        } else {
            return solve(board, row, column+1);
        }

        return false;
    }

    private boolean change(int row, int column, char val, char[][] board) {
        //To check if val is used in row, column and sub-box
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val
                    || board[i][column] == val
                        || board[3*(row/3) + i/3][3*(column/3) + i%3] == val) {
                return false;
            }
        }
        board[row][column] = val;
        return true;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."
//                "..9748632","783652419","426139875","357986241","264317598","198524367","975863124","832491756","641275983"
        );

        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = list.get(i).charAt(j);
            }
        }
        new Sudoku_Solver_37().solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
