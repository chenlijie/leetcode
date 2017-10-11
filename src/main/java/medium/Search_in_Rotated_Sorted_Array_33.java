package medium;

/**
 * Created by chenlijie on 5/21/17.
 */
public class Search_in_Rotated_Sorted_Array_33 {

    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length;
        int middle;

        while (low < high) {
            middle = low + (high-low)/2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[low] < nums[middle]) {
                if (target >= nums[low] && target < nums[middle]) {
                    high = middle;
                } else {
                    low = middle + 1;
                }
            } else {
                if (target > nums[middle] && target <= nums[high-1]) {
                    low = middle + 1;
                } else {
                    high = middle;
                }
            }
        }

        return -1;
    }


    public static int search2(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;

        while (nums[lo] == nums[hi]) {
            lo++;
        }

        while (lo <= hi) {
            int mi = lo + (hi-lo)/2;

            if (target == nums[mi]) {
                return mi;
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
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1}, 0) );
        System.out.println(search2(new int[]{1,3,1,1,1}, 3) == 1);
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
