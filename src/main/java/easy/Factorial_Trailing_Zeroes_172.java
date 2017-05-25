package easy;

/**
 * Created by chenlijie on 5/13/17.
 */
public class Factorial_Trailing_Zeroes_172 {

    public static int trailingZeroes(int n) {

        int count = 0;
        while (n > 0) {
            n = n/5;
            count += n;
        }
        return count;

//        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(16));
    }
}
