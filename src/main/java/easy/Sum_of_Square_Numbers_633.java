package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenlijie on 12/14/17.
 */
public class Sum_of_Square_Numbers_633 {

    static boolean judgeSquareSum(int c) {
        Set<Integer> squres = new HashSet<>();

        for (int i = 0; i <= c; i++) {
            squres.add(i*i);
            if (squres.contains(c - i*i)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(999999999));
    }
}
