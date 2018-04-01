package ebay;

public class TicTacToe {

    int[] rows;
    int[] cols;
    int[] diagonals;
    int size;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonals = new int[2];
        size = n;
    }

    boolean play(int player, int x, int y) {
        int increase = player == 1 ? 1 : -1;
        player--;

        boolean res = (rows[y] += increase) == size * increase
                        || (cols[x] += increase) == size * increase
                        || (x == y && (diagonals[0] += increase) == size * increase)
                        || (x + y == size - 1 && (diagonals[1] += increase) == size * increase);

        if (res)
            System.out.println(++player + " win!");

        return res;
    }

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe(3);
        t.play(2, 2, 0);
//        t.play(2, 0, 1);

        t.play(2, 2, 1);
//        t.play(2, 1, 2);

        t.play(2, 2, 2);
//        t.play(2, 2, 2);

//        t.play(1, 2, 0);
//        t.play(2, 0, 1);
//        t.play(2, 0, 2);

    }
}
