package bit;

/**
 * Created by chenlijie on 9/26/17.
 */
public class BitConversion {

    static int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c >>> 1) {
            count += (c & 1);
        }
        return count;
    }

    static int bitSwapRequired2(int a, int b) {
        int c = 0;
        for (int i = 0; i < 32; i++) {
            if ((a & 1) != (b & 1)) {
                c++;
            }
            a >>>= 1;
            b >>>= 1;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println((-1)>>1);
        System.out.println(bitSwapRequired(-1, 0));
    }
}
