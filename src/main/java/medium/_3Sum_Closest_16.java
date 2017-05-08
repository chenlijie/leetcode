package medium;

import java.util.Arrays;

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

        int low = 0;
        int high = nums.length-1;
        int m = (low + high)/2;

        while(low+2 < high) {
            m = (low + high)/2;
            if (nums[m-1]+nums[m]+nums[m+1] < target) {
                low = (m+high)/2;
            } else if (nums[m-1]+nums[m]+nums[m+1] > target) {
                high = (low+m)/2;
            } else {
                return target;
            }
        }

        if ((nums[m-1]+nums[m]+nums[m+1]) > target) {
            while((nums[m-1]+nums[m]+nums[m+1]) > target && m >= 2) {
                m--;
            }
            if ((m+2<=nums.length-1) && (Math.abs(nums[m-1]+nums[m]+nums[m+1]-target) > Math.abs(nums[m]+nums[m+1]+nums[m+2]-target)))
                return nums[m]+nums[m+1]+nums[m+2];
            else
                return nums[m-1]+nums[m]+nums[m+1];
        } else {
            while((nums[m-1]+nums[m]+nums[m+1]) < target && m <= nums.length-3) {
                m++;
            }
            if ((m-2)>=0 && (Math.abs(nums[m-1]+nums[m]+nums[m+1]-target) > Math.abs(nums[m-2]+nums[m-1]+nums[m]-target)))
                return nums[m-2]+nums[m-1]+nums[m];
            else
                return nums[m-1]+nums[m]+nums[m+1];
        }


    }

    public int threeSumClosest2(int[] nums, int target) {

        Arrays.sort(nums);

        int temp = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(temp - target)) {
                        temp = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return temp;

    }

    public static void main(String[] args) {
        System.out.println(new _3Sum_Closest_16().threeSumClosest(new int[]{0,2,1,-3}, 1));

    }
}
