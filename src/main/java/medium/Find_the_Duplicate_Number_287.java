package medium;

import java.util.Arrays;

/**
 * Created by chenlijie on 5/16/17.
 */
public class Find_the_Duplicate_Number_287 {

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums.length-1;
        int middle;

        while(low < high) {
            middle = low + (high-low)/2;

            if (nums[middle] > middle) {
                low = middle+1;
            } else {
                high = middle;
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,1,1,1,1}));
        System.out.println(findDuplicate(new int[]{1,1,1,1,4}));
        System.out.println(findDuplicate(new int[]{1,4,4,4,4}));
        System.out.println(findDuplicate(new int[]{1,2,3,4,5,6,7,7}));
        System.out.println(findDuplicate(new int[]{1,2,3,3,4,5,6,7,}));
        System.out.println(findDuplicate(new int[]{1,2,3,3,3,5,6,7,8}));
    }
}
