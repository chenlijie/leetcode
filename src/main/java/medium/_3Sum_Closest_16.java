package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 4/19/17.
 */
public class _3Sum_Closest_16 {


    /**
     * -3, -2, -1, 0, 1
     * 0    1   2  3  4
     * -10 10  5
     */
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int min = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {

            int j = i+1;
            int k = nums.length-1;

            while (j < k) {
                if (Math.abs(nums[i] + nums[j] + nums[k] - target) < min) {
                    min = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    closest = nums[i] + nums[j] + nums[k];
                }

                if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }

            while (i < nums.length-2 && nums[i] == nums[i+1]) {
                i++;
            }
        }

        return closest;

    }

    public static void main(String[] args) {
        System.out.println(new _3Sum_Closest_16().threeSumClosest(new int[]{1,1,-1,-1,3}, 3));

    }
}
