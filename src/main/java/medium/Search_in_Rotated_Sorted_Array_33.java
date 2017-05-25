package medium;

/**
 * Created by chenlijie on 5/21/17.
 */
public class Search_in_Rotated_Sorted_Array_33 {

    public static int search(int[] nums, int target) {
        if (nums.length != 0) {

            int low = 0;
            int high = nums.length;
            int middle;

            while (low < high) {
                middle = low + (high-low)/2;
                if (nums[middle] == target) {
                    return middle;
                }

//                if (nums[low] < nums[high]) {
                    if (target < nums[middle]) {
                        high = middle;
                    } else {
                        low = middle + 1;
                    }
                /*} else {
                    if(target < nums[middle]) {
                        high = middle;
                    } else {
                        low = middle + 1;
                    }
                }*/
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
    }
}
