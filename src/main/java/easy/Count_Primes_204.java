package easy;

/**
 * Created by chenlijie on 5/10/17.
 */
public class Count_Primes_204 {

    public static int countPrimes(int n) {

        int len = (int)Math.sqrt(n);

        int[] nums = new int[n];

        for (int i = 2; i < nums.length; i++) {
            nums[i] = 1;
        }

        for (int i = 2; i <= len; i++) {

            for (int j = 2; i*j < n; j++) {
                if (nums[i] == 1) {
                    nums[i*j] = 0;
                }
            }
        }

        int sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(100));
    }
}
