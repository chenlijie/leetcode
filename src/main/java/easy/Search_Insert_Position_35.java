package easy;

/**
 * Created by chenlijie on 8/6/17.
 */
public class Search_Insert_Position_35 {

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        if (target <= nums[low]) {
            return 0;
        }

        if (target > nums[high]) {
            return nums.length;
        }

        while (low <= high) {
            int middle = low + (high-low)/2;

            if (target == nums[middle]) {
                return middle;
            } else if ( middle >= 1 && target > nums[middle-1] && target < nums[middle]) {
                return middle;
            } else if (target > nums[middle] && target < nums[middle+1]) {
                return middle+1;
            }

            if (target > nums[middle]) {
                low = middle+1;
            } else {
                high = middle;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));

    }
}
