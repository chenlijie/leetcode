package linkedin;

import java.util.Arrays;

/**
 * Created by chenlijie on 12/12/17.
 */
public class Triangle {

    // e < a <= b <= c
    // a + b > c
    // e + b > c => a + b > c
    static boolean canMakeTriangle(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        for (int i = 2; i < len; i++) {
            if (nums[i-2] + nums[i-1] > nums[i]) {
                System.out.println(nums[i-2] + "+" + nums[i-1] + ">" + nums[i]);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(canMakeTriangle(new int[]{1,2,4,6,9}));
        System.out.println(canMakeTriangle(new int[]{1,3,3,6,8}));
        System.out.println(canMakeTriangle(new int[]{1,2,3,5,8}));
    }
}
