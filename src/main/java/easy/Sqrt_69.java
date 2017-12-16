package easy;

import java.util.Random;

/**
 * Created by chenlijie on 12/9/17.
 */
public class Sqrt_69 {
    static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int ans = 1;
        int lo = 1;
        int hi = x/2;

        while (lo <= hi) {
            int mi = (lo + hi)/2;

            if (x/mi >= mi) {
                // if (x/(mi+1) < mi+1)
                //     return mi;
                ans = mi;
                lo = mi + 1;
            } else {
                hi = mi-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
    }
}
