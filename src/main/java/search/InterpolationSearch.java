package search;

/**
 * Created by chenlijie on 9/1/17.
 */
public class InterpolationSearch {

    public static int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length-1;
        int mi;

        int count = 0;

        while (lo <= hi && target >= nums[lo] && target <= nums[hi]) {

            count++;

            mi = lo + (hi-lo)*(target-nums[lo])/(nums[hi]-nums[lo]);

            if (nums[mi] == target) {
                System.out.println("It takes " + count + " times to search.");
                return target;
            } else if (nums[mi] < target) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[1001];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        nums[1000] = 10000*1000*1000;

        search(nums, 100);

        search(new int[]{1, 10, 100, 125, 200, 220, 300, 1000}, 100);
        search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1000}, 9);
    }
}
