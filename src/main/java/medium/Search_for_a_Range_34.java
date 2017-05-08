package medium;

/**
 * Created by chenlijie on 5/3/17.
 */
public class Search_for_a_Range_34 {

    public static int[] searchRange2(int[] nums, int target) {

        int left = search(nums, target);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int right = search(nums, target+1) -1;

        return new int[]{left, right};
    }

    static int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo + hi)/2;

            if (nums[mi] >= target) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        return lo;
    }


    public static int[] searchRange(int[] nums, int target) {

        int lo = findLow(nums, target, 0, nums.length-1);
        if (lo == -1) {
            return new int[]{-1, -1};
        }

        int hi = findHigh(nums, target, 0, nums.length-1);

        return new int[]{lo, hi};
    }

    static int findLow(int[] nums, int target, int lo, int hi) {

        while (lo < hi) {
            int mi = (lo + hi)/2;

            if (nums[mi] < target) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return target != nums[lo] ? -1 : lo;
    }

    static int findHigh(int[] nums, int target, int lo, int hi) {

        while (lo < hi) {
            int mi = (lo + hi + 1)/2;

            if (nums[mi] > target) {
                hi = mi - 1;
            } else {
                lo = mi;
            }
        }
        return target != nums[hi] ? -1 : hi;
    }


    public static void main(String[] args) {

        int[] array = new int[]{0, 1, 2, 2, 2, 3, 4, 5};
        int[] res = searchRange2(array, 2);

        System.out.println(res[0] + ", " + res[1]);
//        testFindLow();
//        testFindHigh();
    }

    static void testFindHigh() {
        int[] array = new int[]{0, 2};
        System.out.println(findHigh(array, 1, 0, array.length-1));
    }


    static void testFindLow() {
//        System.out.println(findLow(new int[]{1, 2, 3, 4}, 2, 0, 4));

        int[] array = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println(findLow(array, 2, 0, array.length-1));
    }
}
