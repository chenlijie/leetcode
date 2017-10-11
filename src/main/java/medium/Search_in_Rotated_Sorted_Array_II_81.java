package medium;

/**
 * Created by chenlijie on 9/5/17.
 */
public class Search_in_Rotated_Sorted_Array_II_81 {

    public static boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;

        while (lo < hi && nums[lo] == nums[hi]) {
            lo++;
        }

        while (lo <= hi) {
            int mi = lo + (hi-lo)/2;

            if (target == nums[mi]) {
                return true;
            }
            if (nums[lo] <= nums[mi]) {
                if (target < nums[mi] && target >= nums[lo]) {
                    hi = mi - 1;
                } else {
                    lo = mi + 1;
                }
            }  else {
                if (target > nums[mi] && target <= nums[hi]) {
                    lo = mi + 1;
                } else {
                    hi = mi - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1}, 0) );
    }
}
