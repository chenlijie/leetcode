package hard;

public class Paint_House_II_265 {

    public int minCostII(int[][] costs) {
        if (costs.length == 0)
            return 0;

        int rows = costs.length;
        int cols = costs[0].length;
        int[] ans = new int[cols];
        int[] idxOfMin = new int[3];

        for (int i = 0; i < cols; i++) {
            ans[i] = costs[0][i];
            if (i <= 1) {
                idxOfMin[i] = i;
            } else {
                idxOfMin[2] = i;
                swapMin(idxOfMin, ans);
            }
        }

        for (int i = 1; i < rows; i++) {

            int idx0 = idxOfMin[0];
            int idx1 = idxOfMin[1];
            int min0 = ans[idx0];
            int min1 = ans[idx1];

            for (int j = 0; j < cols; j++) {
                if (j != idx0 && j != idx1) {
                    ans[j] = costs[i][j] + Math.min(min0, min1);
                } else if (j == idx0) {
                    ans[j] = costs[i][j] + min1;
                } else {
                    ans[j] = costs[i][j] + min0;
                }

                if (j <= 1) {
                    idxOfMin[j] = j;
                } else {
                    idxOfMin[2] = j;
                    swapMin(idxOfMin, ans);
                }
            }
        }

        return cols <= 1 ? ans[idxOfMin[0]] : Math.min(ans[idxOfMin[0]], ans[idxOfMin[1]]);
    }

    void swapMin(int[] idxOfMin, int[] ans) {
        int largest = 2;
        if (ans[idxOfMin[largest]] < ans[idxOfMin[0]]) {
            largest = 0;
        }
        if (ans[idxOfMin[largest]] < ans[idxOfMin[1]]) {
            largest = 1;
        }
        if (largest != 2) {
            int t = idxOfMin[largest];
            idxOfMin[largest] = idxOfMin[2];
            idxOfMin[2] = t;
        }
    }

    public static void main(String[] args) {
        Paint_House_II_265 p = new Paint_House_II_265();
        System.out.println(p.minCostII(new int[][]{{17,9,6,2,6,18,8,12,3,5,9,11,20,8,13,16}}));
    }
}
