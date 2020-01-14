package medium;

import java.util.Random;

public class Random_Pick_with_Weight_528 {

    int[] sum;

    public Random_Pick_with_Weight_528(int[] w) {
        sum = new int[w.length];

        for (int i = 0; i < w.length; i++) {
            if (i == 0) {
                sum[i] = w[i];
            } else {
                sum[i] = sum[i - 1] + w[i];
            }
        }
    }

    // 0  1    2    3
    // 3, 14, 1,   7
    // 3, 17, 18, 25
    public int pickIndex() {
        int total = sum[sum.length - 1];
        int r = 3;//new Random().nextInt(total);

        int lo = 0;
        int hi = sum.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (r >= sum[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        Random_Pick_with_Weight_528 r = new Random_Pick_with_Weight_528(new int[] {3, 14, 1, 7});
        System.out.println(r.pickIndex());
        System.out.println(r.pickIndex());
        System.out.println(r.pickIndex());
    }
}
