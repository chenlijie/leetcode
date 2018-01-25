package linkedin;

public class MultiDimenArraySum {

    static class MultiDimenArray {
        int get(int[] idx) {
            return 0;
        }
    }

    static int sum(MultiDimenArray array, int[] dim) {
        return dfs(array, dim, new int[dim.length], 0);
    }

    static int dfs(MultiDimenArray array, int[] dim, int[] idx, int d) {
        if (d == dim.length) {
            return array.get(idx);
        }

        int sum = 0;
        for (int i = 0; i < dim[d]; i++) {
            idx[d] = i;
            sum += dfs(array, dim, idx, d+1);
        }
        return sum;
    }
}
