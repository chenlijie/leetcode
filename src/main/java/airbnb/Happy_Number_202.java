package airbnb;

import java.util.HashSet;
import java.util.Set;

public class Happy_Number_202 {

    static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                sum += Math.pow(n%10, 2);
                n /= 10;
            }
            n = sum;
            System.out.println(n);
            if (!seen.add(n)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }
}
