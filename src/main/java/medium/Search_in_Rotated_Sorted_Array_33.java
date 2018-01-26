package medium;

/**
 * Created by chenlijie on 5/21/17.
 */
public class Search_in_Rotated_Sorted_Array_33 {

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int rot = getRotation(nums);
        int len = nums.length;

        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int realMi = (mi + rot) % len;

            if (target == nums[realMi]) {
                return realMi;
            } else if (target > nums[realMi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return -1;
    }

    int getRotation(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mi = (lo + hi) / 2;

            if (nums[mi] > nums[hi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
//        System.out.println(search(new int[]{1}, 0) );
//        System.out.println(search(new int[]{1}, 1) == 0);
//        System.out.println(search(new int[]{1}, 2) == -1);
//        System.out.println(search(new int[]{1, 3}, 0) == -1);
//        System.out.println(search(new int[]{1, 3}, 2) == -1);
//        System.out.println(search(new int[]{1, 3}, 5) == -1);
//        System.out.println(search(new int[]{1, 3}, 1) == 0);
//        System.out.println(search(new int[]{1, 3}, 3) == 1);

//        System.out.println(search2(new int[]{6, 8, 9, 0, 1, 2, 4}, 8) == 1);
//        System.out.println(search2(new int[]{6, 8, 9, 0, 1, 2, 4}, 6) == 0);
//        System.out.println(search2(new int[]{6, 8, 9, 0, 1, 2, 4}, 7) == -1);
//        System.out.println(search2(new int[]{6, 8, 9, 0, 1, 2, 4}, 8) == 1);
//        System.out.println(search2(new int[]{6, 8, 9, 0, 1, 2, 4}, 9) == 2);
//        System.out.println(search2(new int[]{6, 8, 9, 0, 1, 2, 4}, 0) == 3);
//        System.out.println(search2(new int[]{6, 8, 9, 0, 1, 2, 4}, 2) == 5);
//        System.out.println(search2(new int[]{6, 8, 9, 0, 1, 2, 4}, 3) == -1);
//        System.out.println(search2(new int[]{6, 8, 9, 0, 1, 2, 4}, 4) == 6);
//        System.out.println(search2(new int[]{4, 5, 6, 7, 0, 1, 2}, 1) == 5);

    }
}
