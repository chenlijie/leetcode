package medium;

/**
 * Created by chenlijie on 5/21/17.
 */
public class Search_in_Rotated_Sorted_Array_33 {

    public static int search(int[] nums, int target) {
        if (nums.length != 0) {

            int low = 0;
            int high = nums.length-1;
            int middle;

            while (low < high) {
                middle = low + (high-low)/2;
                if (nums[middle] == target) {
                    return middle;
                } else if (target > nums[middle] && target < nums[high]) {
                    low = middle;
                } else if (target > nums[middle] && target > nums[low]) {
                    high = middle - 1;
                } else if(target < nums[middle] && target > nums[low]) {
                    high = middle - 1;
                } else {
                    low = middle;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

//        System.out.println(search(new int[]{1}, 0));
        System.out.println(search(new int[]{5, 1, 3}, 5));
//        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
//        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));

        int c = 0;
        for (int i = 0; i < 16; i++) {
            c += i;
        }
        System.out.println(c);
    }
}
