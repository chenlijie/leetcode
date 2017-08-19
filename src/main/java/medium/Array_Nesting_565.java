package medium;

/**
 * Created by chenlijie on 8/16/17.
 */
public class Array_Nesting_565 {

    public static int arrayNesting(int[] nums) {

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            int count = 0;
            while (nums[i] != -1) {
                count++;
                int t = nums[i];
                nums[i] = -1;
                i = t;
            }
            max = Math.max(count, max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[]{5,4,0,3,1,6,2}));
    }
}
