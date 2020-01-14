package microsoft.onsite;

import java.util.Collections;

public class WoodCut {

    public int woodCut(int[] L, int k) {
        // write your code here

        int len = L.length;
        int lo = 1;
        int hi = 1;

        for (int i : L) {
            hi = Math.max(i, hi);
        }

        int ans = -1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;

            if (getPieces(mi, L) >= k) {
                ans = mi;
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }

        System.out.println(ans);

        return ans;
    }

    int getPieces(int n, int[] L) {
        int cnt = 0;
        for (int l : L) {
            cnt += l/n;
        }

        return cnt;
    }

    public static void main(String[] args) {
        WoodCut cut = new WoodCut();
        cut.woodCut(new int[] {6,6,5,4,5,5,6,6}, 6);

        int[][] num = new int[][] {
                {2,4},
                {1,3},
                {5,1}
        };
    }
}
