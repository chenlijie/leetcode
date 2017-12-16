package medium;

import utility.Utils;

/**
 * Created by chenlijie on 11/21/17.
 */
public class Ugly_Number_II_264 {

    static int nthUglyNumber(int n) {

        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] indices = new int[] {0, 0, 0};
        int[] factors = new int[] {2, 3, 5};
        int[] values = new int[] {2, 3, 5};

        for (int i = 1; i < n; i++) {
            int next = Integer.MAX_VALUE;
            Utils.printArray(values);
            for (int j = 0; j < values.length; j++) {
                next = Math.min(next, values[j]);
            }
            ugly[i] = next;

            for (int j = 0; j < indices.length; j++) {
                if (next == values[j]) {
                    indices[j]++;
                    values[j] = ugly[indices[j]] * factors[j];
                }
            }
        }

        return ugly[n-1];
    }

    public static void main(String[] args) {
        nthUglyNumber(10);
    }
}
