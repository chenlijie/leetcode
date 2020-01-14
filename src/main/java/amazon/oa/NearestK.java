package amazon.oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NearestK {

    public static int[] nearest(List<Integer> l1, List<Integer> l2, int k) {
        if (l1 == null || l1.size() == 0 || l2 == null || l2.size() == 0)
            return new int[0];

        int[] ans = new int[2];
        long min = Long.MAX_VALUE;

        for (int i = 0; i < l1.size(); i++) {
            for (int j = 0; j < l2.size(); j++) {
                if (min > Math.abs((long)l1.get(i) + l2.get(j) - k)) {
                    min = Math.abs((long)l1.get(i) + l2.get(j) - k);
                    ans[0] = l1.get(i);
                    ans[1] = l2.get(j);
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);

        return ans;
    }

    public static int[] nearestBinarySearch(List<Integer> l1, List<Integer> l2, int k) {
        if (l1 == null || l1.size() == 0 || l2 == null || l2.size() == 0)
            return new int[0];

        Collections.sort(l2);

        long min = Long.MAX_VALUE;
        int[] ans = new int[2];

        for (int i = 0; i < l1.size(); i++) {
            long t = (long)k - l1.get(i);

            int lo = 0;
            int hi = l2.size();

            while (lo < hi) {
                int mi = (lo + hi) / 2;

                if (l2.get(mi) > t) {
                    hi = mi;
                } else if (l2.get(mi) < t) {
                    lo = mi + 1;
                } else {
                    return new int[] {l1.get(i), l2.get(mi)};
                }
            }

                if (lo != 0 && min > Math.abs((long)l1.get(i) + l2.get(lo - 1) - k)) {
                    min = Math.abs((long)l1.get(i) + l2.get(lo - 1) - k);
                    ans[0] = l1.get(i);
                    ans[1] = l2.get(lo - 1);
                }

                if (lo != l2.size() && min > Math.abs((long)l1.get(i) + l2.get(lo) - k)) {
                    min = Math.abs((long)l1.get(i) + l2.get(lo) - k);
                    ans[0] = l1.get(i);
                    ans[1] = l2.get(lo);
                }

//            if (lo == l2.size()) {
//                if (min > Math.abs((long)l1.get(i) + l2.get(lo - 1) - k)) {
//                    min = Math.abs((long)l1.get(i) + l2.get(lo - 1) - k);
//                    ans[0] = l1.get(i);
//                    ans[1] = l2.get(lo - 1);
//                }
//            } else if (lo == 0) {
//                if (min > Math.abs((long)l1.get(i) + l2.get(lo) - k)) {
//                    min = Math.abs((long)l1.get(i) + l2.get(lo) - k);
//                    ans[0] = l1.get(i);
//                    ans[1] = l2.get(lo);
//                }
//            } else {
//                if (min > Math.abs((long)l1.get(i) + l2.get(lo) - k)) {
//                    min = Math.abs((long)l1.get(i) + l2.get(lo) - k);
//                    ans[0] = l1.get(i);
//                    ans[1] = l2.get(lo);
//                }
//
//                if (lo + 1 < l2.size() && min > Math.abs((long)l1.get(i) + l2.get(lo + 1) - k)) {
//                    min = Math.abs((long)l1.get(i) + l2.get(lo - 1) - k);
//                    ans[0] = l1.get(i);
//                    ans[1] = l2.get(lo + 1);
//                }
//            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(4);l1.add(0);
        l1.add(Integer.MAX_VALUE);
        l1.add(9);
        List<Integer> l2 = new ArrayList<>();
        l2.add(14);l2.add(8);
        l2.add(Integer.MAX_VALUE);l2.add(Integer.MAX_VALUE);
        l2.add(2);

//        nearest(l1, l2, 17);
//        nearest(l1, l2, 7);
//        nearest(l1, l2, -1);

//        int[] ans = nearestBinarySearch(l1, l2, -1);
        nearest(l1, l2, 7);
        int[] ans = nearestBinarySearch(l1, l2, 7);
        System.out.println(ans[0] + " " + ans[1]);

        System.out.println();

        nearest(l1, l2, 17);
        ans = nearestBinarySearch(l1, l2, 17);
        System.out.println(ans[0] + " " + ans[1]);

//        System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);

    }
}
