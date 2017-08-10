package medium;

/**
 * Created by chenlijie on 8/8/17.
 */
public class Permutation_Sequence_60 {

    public static String getPermutation(int n, int k) {

        int[] used = new int[n+1];
        int total = 1;
        for (int i = 1; i <= n; i++) {
            total *= i;
        }

        if (k > total || k < 1) {
            return "";
        }

        int base = total/n;
        int m = 0;
        StringBuilder permutation = new StringBuilder("");

        while (k > (m++)*base) {

            if (k <= m*base) {
                //find number
                int t = 0;
                for (int i = 1; i < used.length; i++) {
                    if (used[i] == 0 && ++t == m) {
                        permutation.append(i);
                        used[i] = 1;
                        break;
                    }
                }

                k -= (m-1)*base;
                base /= (--n == 0 ? 1 : n);
                m = 0;

                if (permutation.length() == used.length-1) {
                    break;
                }
            }
        }

        return permutation.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(1, 1));
    }

    /*
    2 3 1

    4*3*2*1 = 24
    1-6
    7-12
    13-18
    19-24

    3 4 1 2

    */
}
