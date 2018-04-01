package ebay;

public class SelfCrossing {

    static boolean isSelfCrossing(int[] x) {
        int len = x.length;

        for (int i = 3; i < len; i++) {
            if (x[i - 3] >= x[i - 1] && x[i] >= x[i - 2])
                return true;

            if (i >= 4 && x[i - 4] + x[i] >= x[i - 2] && x[i - 1] == x[i - 3])
                return true;

            if (i >= 5 && x[i-3] >= x[i-1]
                    && x[i-2] > x[i-4]
                    && x[i-2] <= x[i] + x[i-4]
                    && x[i-1] + x[i-5] >= x[i-3])
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] n = new int[] {1, 2, 2, 1, 3};
        System.out.println(isSelfCrossing(n));
    }
}
