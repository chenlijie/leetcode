package amazon.oa;

import utility.Utils;

import java.util.Arrays;



public class CountLessThanOrEqualTo {

//    For each element in 1st array count elements less than or equal to it in 2nd array

    static void solution(int[] nums, int[] maxs) {
        Arrays.sort(nums);
        int[] ans = new int[maxs.length];

        for (int i = 0; i < maxs.length; i++) {
            ans[i] = search(nums, maxs[i]);
        }

        Utils.printArray(ans);
    }

    static int search(int[] nums, int t) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (t >= nums[mi])
                lo = mi + 1;
            else
                hi = mi;
        }

        return lo;
    }

    public static void main(String[] args) {
        solution(new int[] {0, 1, 2, 1, 1, 4}, new int[] {1, 2, 3, 4, 7, 9});
        solution(new int[] {6, 5, 11, 4, 2, 3, 7}, new int[] {5, 10, 2, 6, 1, 8, 6, 12});
    }
}
