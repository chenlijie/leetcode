package microsoft.onsite;

import java.util.Arrays;

public class MaxNumber {

    static int maxNumber(int num) {
        int positveMaxLen = String.valueOf(Integer.MAX_VALUE).length();
        int negatvieMaxLen = String.valueOf(Integer.MIN_VALUE).length();

        boolean positive = num >= 0;
        char[] c = String.valueOf(num).toCharArray();

        int i = positive ? 0 : 1;
        Arrays.sort(c, i, c.length);

        if (positive) {
            if (c.length < positveMaxLen)
                return getMaxPositive(c);
            else
                return getMax(0, 0, c, new boolean[positveMaxLen], true);
        }

        return 0;

    }

    static int getMax(int num, int counter, char[] c, boolean[] visited, boolean positive) {
        int max = num;

        for (int i = positive ? 0 : 1; i < c.length; i++) {
            if (!visited[i]) {
                max = Math.max(max, num + 10 * getMax(num, counter + 1, c, visited, positive));
            }
        }

        return 0;
    }

    static int getMaxPositive(char[] c) {
        int base = 1;
        int max = 0;
        for (int i = c.length - 1; i >= 0; i++) {
            max += (c[i] - '0') * base;
            base *= 10;
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE - 10);
        System.out.println(String.valueOf(-10));
    }
}
