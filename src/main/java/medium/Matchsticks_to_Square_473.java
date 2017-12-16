package medium;

import java.util.Arrays;

/**
 * Created by chenlijie on 11/16/17.
 */
public class Matchsticks_to_Square_473 {

    public boolean makesquare(int[] nums) {
        if (nums == null && nums.length < 4)
            return false;

        int sum = 0;
        int len = nums.length;

        for (int i : nums) {
            sum += i;
        }

        if (sum%4 != 0)
            return false;

        int width = sum/4;

        Arrays.sort(nums);
        int cnt = 0;
        boolean[] visited = new boolean[len];

        for (int i = len-1; i >= 0; i--) {
            if (nums[i] != -1 ) {
                if (helper(width, i, nums, visited))
                    cnt++;
                else
                    return false;
            }
        }

        return cnt == 4;
    }

    boolean helper(int width, int i, int[] nums, boolean[] visited) {
        if (width == 0)
            return true;

        if (i < 0)
            return false;

        for (int j = i; j >= 0; j--) {

            boolean find = false;
            if (!visited[j] && width >= nums[i]) {
                if (helper(width - nums[j], j - 1, nums, visited)) {
                    visited[j] = true;
                    return true;
                }
            } else {
                if (helper(width, i - 1, nums, visited))
                    return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,3,3,3,4,4,4,4,5,5,5,5};

        System.out.println(new Matchsticks_to_Square_473().makesquare(nums));
    }

}
