package dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 10/19/17.
 */
public class FibonacciNumbers {

    static int fibonacci(int i, Map<Integer, Integer> cache) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else {
            int first;
            if (cache.containsKey(i - 1)) {
                first = cache.get(i - 1);
            } else {
                first = fibonacci(i - 1, cache);
                cache.put(i - 1, first);
            }

            int second;
            if (cache.containsKey(i - 2)) {
                second = cache.get(i - 2);
            } else {
                second = fibonacci(i - 2, cache);
                cache.put(i - 2, second);
            }
            return first + second;
        }
    }

    static int bottomUp(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int a = 0;
        int b = 1;
        int t;

        for (int i = 2; i <= n; i++) {
            t = b;
            b = a + b;
            a = t;

    }

        return b;
    }


    public static void main(String[] args) {
        System.out.println(fibonacci(10, new HashMap<>()));
        System.out.println(bottomUp(10));
    }

}
