package facebook;

public class WoodCut {

    //http://www.lintcode.com/en/problem/wood-cut/
    public int woodCut(int[] L, int k) {
        // write your code here

        int len = L.length;
        int lo = 1;
        int hi = 1;

        for (int i : L) {
            hi = Math.max(i, hi);
        }

        int ans = -1;
        while (lo + 1 < hi) {
            int mi = lo + (hi - lo) / 2;

            if (getPieces(mi, L) >= k) {
                // ans = mi;
                lo = mi;
            } else {
                hi = mi;
            }
        }

        if (getPieces(hi, L) >= k) {
            return hi;
        }
        if (getPieces(lo, L) >= k) {
            return lo;
        }

        return 0;

        // return ans == -1 ? 0 : ans;
    }

    int getPieces(int n, int[] L) {
        int cnt = 0;
        for (int l : L) {
            cnt += l/n;
        }

        return cnt;
    }
}
