package sort;

/**
 * Created by chenlijie on 8/28/17.
 */
public class Single_Element_in_a_Sorted_Array_540 {

    public static int singleNonDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length;

        while (low+1 < high) {
            int middle = (low+high)/2;

            if (nums[middle] != nums[middle+1] && nums[middle] != nums[middle-1]) {
                return nums[middle];
            } else if (middle%2 == 1) {
                if (nums[middle] == nums[middle-1]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            } else {
                if (nums[middle] != nums[middle-1]) {
                    low = middle + 2;
                } else {
                    high = middle - 1;
                }
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
//        System.out.println(singleNonDuplicate(new int[]{1,1,2,2,3}));
//        System.out.println(singleNonDuplicate(new int[]{1,1,2,2,3,3,4,4,5,6,6}));
//        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,5,5,6,6}));
//        System.out.println(singleNonDuplicate(new int[]{1,2,2,3,3,4,4,5,5,6,6}));
        System.out.println(singleNonDuplicate(new int[]{1,1,2,2,3,3,4,4,5,5,6}));
        System.out.println(singleNonDuplicate(new int[]{1,2,2,3,3,4,4,5,5,6,6,7,7}));
    }
}
