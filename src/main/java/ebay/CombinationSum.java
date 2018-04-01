package ebay;

import java.util.Arrays;

public class CombinationSum {

    //unique combination
    static int combinationUnique(int[] nums, int t) {
        Arrays.sort(nums);
        int c = backTrackingUnique(nums, 0, t);
        System.out.println("unique combination is " + c);
        return c;
    }

    static int backTrackingUnique(int[] nums, int start, int remain) {
        if (remain == 0)
            return 1;

        int count = 0;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;

            if (remain >= nums[i]) {
                count += backTrackingUnique(nums, i + 1, remain - nums[i]);
            }
        }

        return count;
    }

    //all combination
    static int combination(int[] nums, int t) {
        int c = backTracking(nums, t, new boolean[nums.length]);
        System.out.println("unique combination is " + c);
        return c;
    }

    static int backTracking(int[] nums, int remain, boolean[] used) {
        if (remain == 0)
            return 1;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if (!used[i] && remain >= nums[i]) {
                used[i] = true;
                count += backTracking(nums, remain - nums[i], used);
                used[i] = false;
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        combinationUnique(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
//        combination(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
        combination(new int[] {3, 1, 4, 2}, 8);
        combination(new int[] {1, 2, 3, 4}, 8);
    }
}
