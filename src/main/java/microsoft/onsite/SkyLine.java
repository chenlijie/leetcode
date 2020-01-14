package microsoft.onsite;

import java.util.ArrayList;
import java.util.List;

public class SkyLine {

    public List<int[]> getSkyline(int[][] buildings) {
        int maxRight = 0;

        for (int i = 0; i < buildings.length; i++) {
            maxRight = Math.max(maxRight, buildings[i][1]);
        }

        int[] b = new int[maxRight + 2];

        for (int i = 0; i < buildings.length; i++) {

            int s = buildings[i][0];
            int e = buildings[i][1];

            for (int j = s; j <= e; j++) {
                b[j] = Math.max(b[j], buildings[i][2]);
            }
        }

        List<int[]> ans = new ArrayList<>();

        if (b[0] != 0) {
            ans.add(new int[] {0, b[0]});
        }

        for (int i = 1; i < b.length; i++) {
            if (b[i] > b[i-1])
                ans.add(new int[] {i, b[i]});
            else if (b[i] < b[i-1])
                ans.add(new int[] {i-1, b[i]});
        }

        return ans;
    }
}
