package linkedin;

/**
 * Created by chenlijie on 12/12/17.
 */
public class PerfectSqure {

    static boolean isPerfectSqure(int n) {

        int lo = 1;
        int hi = n;

        while (lo < hi) {
            int mi = (lo + hi) >>> 1;

            if (mi*mi == n) {
                return true;
            } else if (mi*mi < n) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 37; i++) {
            System.out.println(i + " : " + isPerfectSqure(i));
        }
    }
}
