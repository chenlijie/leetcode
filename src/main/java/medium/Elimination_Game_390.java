package medium;

/**
 * Created by chenlijie on 8/24/17.
 */
public class Elimination_Game_390 {

    public static int lastRemaining(int n) {

        int i = 1;
        int j = n;

        if (n >1 && n%2 == 1) {
            i = 2;
            j = n -1;

            j--;
        }

        while (i < j) {
            i++;
            j--;
        }

        return i;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(4));
    }
}
