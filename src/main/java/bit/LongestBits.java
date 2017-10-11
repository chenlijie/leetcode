package bit;

/**
 * Created by chenlijie on 9/25/17.
 */
public class LongestBits {

    public static int longestBits(int num) {

        int count = 0;
        int max = 0;
        int last = 0;
        int zero = 0;

        for (int i = 0; i < 32; i++) {

            if ((num & (1 << i)) == 0) {
                zero++;
                last = i;
            }

            if (zero == 2) {
                max = Math.max(max, count);
                count = 0;
                zero = 0;
                i = last;
                continue;
            }

            count++;
        }

        return Math.max(max, count);
    }

    public static void main(String[] args) {
        System.out.println(longestBits(-2));
    }
}
