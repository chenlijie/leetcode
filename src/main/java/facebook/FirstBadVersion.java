package facebook;

import bit.BitManipulation;
import sun.jvm.hotspot.debugger.cdbg.BitType;

import java.util.Arrays;

/**
 * Created by chenlijie on 12/18/17.
 */
public class FirstBadVersion {

    static int firstBadVersion2(int n) {
        int lo = 1;
        int hi = n;

        while (lo <= hi) {
            int mi = lo + (hi-lo)/2;

            if (isBadVersion(mi)) {
                hi = mi - 1;
            } else {
                if (lo == Integer.MAX_VALUE || lo == n+1) {
                    return -1;
                }
                lo = mi + 1;
            }
        }

        return lo;
    }

    static int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;

        while (lo < hi) {
            int mi = lo + (hi-lo)/2;

            if (isBadVersion(mi)) {
                hi = mi;
            } else {
                if (lo == Integer.MAX_VALUE || lo == n + 1)
                    return -1;
                lo = mi + 1;
            }
        }

        return lo;
    }

    static boolean isBadVersion(int n) {
        if (n < 2147483647)
            return false;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE>>>1);
        System.out.println(Integer.bitCount(-1));

//        System.out.println((int)'1');
//        System.out.println((int)'Z');
//        System.out.println((int)'z');
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(firstBadVersion(Integer.MAX_VALUE));
//        System.out.println(Arrays.binarySearch(new int[]{1, 3, 5, 7, 9}, 0));
//        System.out.println(Arrays.binarySearch(new int[]{1, 3, 5, 7, 9}, 2));
//        System.out.println(Arrays.binarySearch(new int[]{1, 3, 5, 7, 9}, 12));
//        System.out.println(Arrays.binarySearch(new int[]{1, 3, 3, 3, 3, 3, 3, 3, 9}, 3));

    }
}
