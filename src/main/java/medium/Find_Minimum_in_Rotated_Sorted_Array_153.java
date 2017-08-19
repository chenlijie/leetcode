package medium;

/**
 * Created by chenlijie on 8/15/17.
 */
public class Find_Minimum_in_Rotated_Sorted_Array_153 {


    /*
    4 5 6 7 0 1 2

    nums[middle] >= nums[0] -> low = middle + 1
    nums[middle] < nums[len-1] -> high = middle;

     */
    public static int findMin(int[] nums) {

        if (nums[0] <= nums[nums.length-1]) {
            return nums[0];
        }

        int low = 0;
        int high = nums.length;

        while (low < high) {

            int middle = low + (high - low)/2;

            if (nums[middle] >= nums[0]) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{7, 0}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0}));
        System.out.println(findMin(new int[]{7, 0, 1, 2}));
        System.out.println(findMin(new int[]{0, 1, 2}));

    }
}
