package medium;

/**
 * Created by chenlijie on 8/2/17.
 */
public class Can_I_Win_464 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((maxChoosableInteger+1)*maxChoosableInteger/2 < desiredTotal) {
            return false;
        }

        boolean[] used = new boolean[maxChoosableInteger+1];
        for (int i = 1; i <= maxChoosableInteger; i++) {
            used[i] = true;
            boolean win = win(maxChoosableInteger, desiredTotal-i, used, 1);
            if (win) {
                return win;
            }
            used[i] = false;
        }
        return false;
    }

    boolean win(int maxChoosableInteger, int desiredTotal, boolean[] used, int count) {

        if (desiredTotal <= 0) {
            if (count%2 == 1) {
                return true;
            } else {
                return false;
            }
        }

        boolean win = false;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            win = win || win(maxChoosableInteger, desiredTotal-i, used, count+1);
            used[i] = false;
        }

        return win;
    }

    public static void main(String[] args) {
        System.out.println(new Can_I_Win_464().canIWin(10, 11));
    }
}
