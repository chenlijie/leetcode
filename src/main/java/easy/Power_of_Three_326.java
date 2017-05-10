package easy;

/**
 * Created by chenlijie on 5/9/17.
 */
public class Power_of_Three_326 {

    public static boolean isPowerOfThree2(int n) {

        int k = 1;

        while (k < n) {
            k *= 3;
        }

        return k == n;
    }

    public static boolean isPowerOfThree(int n) {

        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            
            n /= 3;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(1));
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(8));
        System.out.println(isPowerOfThree(10));
        System.out.println(isPowerOfThree(6));
    }
}
