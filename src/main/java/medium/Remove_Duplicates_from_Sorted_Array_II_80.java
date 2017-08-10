package medium;

/**
 * Created by chenlijie on 8/9/17.
 */
public class Remove_Duplicates_from_Sorted_Array_II_80 {


    public static int removeDuplicates(int[] nums) {
        int t = 0;
        int j = 1;
        int n = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                if (++t >= 2) {
                    n++;
                } else {
                    nums[j++] = nums[i];
                }
            } else {
                t = 0;
                nums[j++] = nums[i];
            }
        }

        return nums.length - n;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2}));
        System.out.println(removeDuplicates(new int[0]));
    }
}
