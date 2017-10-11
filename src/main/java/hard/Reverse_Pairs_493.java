package hard;

import java.util.Arrays;

/**
 * Created by chenlijie on 9/13/17.
 */
public class Reverse_Pairs_493 {

    public static int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] copy = new int[len];
        copy[0] = nums[len-1];
        int count = 1;
        int pairs = 0;

        for (int i = nums.length-2; i >= 0 ; i--) {
            pairs += getPairs(nums[i]%2 == 0 ? nums[i]/2-1 : nums[i]/2, copy, count);
            copy[count++] = nums[i];
            Arrays.sort(copy, 0, count);
        }

        return pairs;
    }

    private static int getPairs(int num, int[] copy, int count) {
        int lo = 0;
        int hi = count;

        while (lo < hi) {
            int mi = lo + (hi-lo)/2;

            if (num >= copy[mi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
//        int[] copy = new int[] {1,2, 4,5};
//        System.out.println(getPairs(2, copy, copy.length));

        System.out.println(reversePairs(new int[]{5,4,3,2,1}));
    }
}
