package microsoft.onsite;

public class FindKthFromTwoSortedArray {

    static int find(int[] a, int[] b, int k) {
        if (k <= 0 || k > a.length + b.length)
            throw new RuntimeException();

//        if (a.length == 0)
//            return b[k-1];

        if (a.length > b.length)
            return find(b, a, k);

        int lo = 0;
        int hi = Math.min(a.length, k);

        while (lo <= hi) {
            int i = (lo + hi) / 2;
            int j = k - 1 - i;

            if (i < a.length && j - 1 >= 0 && a[i] < b[j - 1]) {
                lo = i + 1;
            } else if (i - 1 >= 0 && b[j] < a[i - 1]) {
                hi = i;
            } else {
                if (i == a.length) {
                    return b[j];
                } else if (j == b.length) {
                    return a[i];
                } else {
                    return Math.min(a[i], b[j]);
                }

            }
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{3}, new int[]{1}, 1));
        System.out.println(find(new int[]{1}, new int[]{2}, 2));
        System.out.println(find(new int[]{2}, new int[]{1,3,5,7}, 1));
        System.out.println(find(new int[]{2}, new int[]{1,3,5,7}, 2));
        System.out.println(find(new int[]{2}, new int[]{1,3,5,7}, 3));
        System.out.println(find(new int[]{2}, new int[]{1,3,5,7}, 4));
        System.out.println(find(new int[]{2}, new int[]{1,3,5,7}, 5));

    }
}
