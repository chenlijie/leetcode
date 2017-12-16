package medium;

import java.util.Arrays;

/**
 * Created by chenlijie on 9/10/17.
 */
public class _3Sum_Smaller_259 {

    public static int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        int len = nums.length;

        for(int i=0; i<len-2; i++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(threeSumSmaller(new int[]{3, 1, 0, -2}, 2));
    }
}
