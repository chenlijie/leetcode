package easy;

/**
 * Created by chenlijie on 7/31/17.
 */
public class Hamming_Distance_461 {

    public int hammingDistance(int x, int y) {

        int t = x^y;
        int d = 0;
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & t) != 0) {
                d++;
            }
        }

        return d;
    }
}
