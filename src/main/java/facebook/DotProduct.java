package facebook;

import java.util.*;

/**
 * Created by chenlijie on 12/25/17.
 */
public class DotProduct {

    int doProduct(int[][] v1, int[][] v2) {
        int[][] shortV;
        int[][] longV;

        if (v1.length < v2.length) {
            shortV = v1;
            longV = v2;
        } else {
            shortV = v2;
            longV = v1;
        }

        int sum = 0;
        for (int i = 0; i < shortV.length; i++) {
            int[] v = shortV[i];
            int idx = binarySearch(v[0], longV);
            if (idx != -1) {
                sum += v[1]*longV[idx][1];
            }
        }
        return sum;
    }

    private int binarySearch(int t, int[][] longV) {
        int lo = 0;
        int hi = longV.length;

        while (lo < hi) {
            int mi = (lo+hi)/2;
            if (longV[mi][0] == t) {
                return mi;
            } else if (longV[mi][0] > t) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        return -1;
    }

    int doProduct2(int[][] v1, int[][] v2) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int[] v : v1) {
            map.put(v[0], v[1]);
        }

        for (int[] v : v2) {
            sum += v[1]*map.getOrDefault(v[0], 0);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] v1 = new int[][] {
                {1, 2},
                {3, 2},
                {6, 3},
                {9, 4}
        };
        int[][] v2 = new int[][] {
                {4, 5},
                {6, 2},
                {9, 8},
        };

        DotProduct p = new DotProduct();
        System.out.println(p.doProduct(v1, v2));
        System.out.println(p.doProduct2(v1, v2));

        System.out.println("ab\n\t".indexOf("\n"));

    }

}
