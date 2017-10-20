package math;

/**
 * Created by chenlijie on 10/19/17.
 */
public class Primality {

    boolean checkPrimality(int n) {
        if (n < 2) {
            return false;
        }

        int k = (int) Math.sqrt(n);

        for (int i = 2; i <= k; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
