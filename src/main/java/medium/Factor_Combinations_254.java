package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 11/5/17.
 */
public class Factor_Combinations_254 {

    static List<List<Integer>> getFactors(int n) {
        if (n < 4) {
            return new ArrayList<>();
        }

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> factors = new ArrayList<>();
        getFactors(n, factors, results);

        return results;
    }

    static void getFactors(int n, List<Integer> factors, List<List<Integer>> results) {
        int start = factors.size() == 0 ? 2 : factors.get(factors.size() - 1);
        int end = (int)Math.sqrt(n);

        for (int i = start; i <= end; i++) {
            if (n % i == 0) {
                factors.add(i);
                factors.add(n / i);
                results.add(new ArrayList<>(factors));
                factors.remove(factors.size() - 1);
                getFactors(n / i, factors, results);
                factors.remove(factors.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getFactors(32));
    }
}
