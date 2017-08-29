package medium;

/**
 * Created by chenlijie on 8/22/17.
 */
public class Counting_Bits_338 {


    /**
     *
     * 1 - 0001
     * 2 - 0010
     * 3 - 0011
     * 4 - 0100
     * 5 - 0101
     * 6 - 0110
     * 7 - 0111
     * 8 - 1000
     * 9 - 1001
     * 10- 1010
     * 11- 1011
     * 12- 1100
     * 13- 1101
     * 14- 1110
     *
     * 1111 1101
     *
     * 1+4+8+16+32+64+128=5+
     *
     */
    public static int[] countBits(int num) {
        int[] dp = new int[num+1];
        for (int i = 0; i <= num; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else {
                if(i < (1<<1)) {
                    dp[i] = dp[i] + 1;
                } else if (i < (1<<2)) {
                    dp[i] = dp[i-(1<<1)] + 1;
                } else if (i < (1<<3)) {
                    dp[i] = dp[i-(1<<2)] + 1;
                } else if (i < (1<<4)) {
                    dp[i] = dp[i-(1<<3)] + 1;
                } else if (i < (1<<5)) {
                    dp[i] = dp[i-(1<<4)] + 1;
                } else if (i < (1<<6)) {
                    dp[i] = dp[i-(1<<5)] + 1;
                } else if (i < (1<<7)) {
                    dp[i] = dp[i-(1<<6)] + 1;
                } else if (i < (1<<8)) {
                    dp[i] = dp[i-(1<<7)] + 1;
                } else if (i < (1<<9)) {
                    dp[i] = dp[i-(1<<8)] + 1;
                } else if (i < (1<<10)) {
                    dp[i] = dp[i-(1<<9)] + 1;
                } else if (i < (1<<11)) {
                    dp[i] = dp[i-(1<<10)] + 1;
                } else if (i < (1<<12)) {
                    dp[i] = dp[i-(1<<11)] + 1;
                } else if (i < (1<<13)) {
                    dp[i] = dp[i-(1<<12)] + 1;
                } else if (i < (1<<14)) {
                    dp[i] = dp[i-(1<<13)] + 1;
                } else if (i < (1<<15)) {
                    dp[i] = dp[i-(1<<14)] + 1;
                } else {
                    dp[i] = dp[i-(1<<15)] + 1;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        for (int i : countBits(5)) {
            System.out.print(i + "  ");
        }
    }
}
