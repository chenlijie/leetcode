package search;

/**
 * Created by chenlijie on 12/2/17.
 */
public class FirstNumberLessThanOrEqualToTarget {

    static int findIndex(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length-1;

        while (lo <= hi) {
            int mi = (lo + hi)/2;

            /*if (nums[mi] == k) {
                return mi;
            }*/ if (nums[mi] < k) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        System.out.println(findIndex(new int[]{1}, 1) == 0);
        System.out.println(findIndex(new int[]{1}, 2) == 1);
        System.out.println(findIndex(new int[]{1, 2}, 1) == 0);
        System.out.println(findIndex(new int[]{1, 2}, 2) == 1);
        System.out.println(findIndex(new int[]{1, 2, 4}, 3) == 2);
    }
}
