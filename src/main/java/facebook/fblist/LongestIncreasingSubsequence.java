package facebook.fblist;

import java.util.*;

public class LongestIncreasingSubsequence {

    //300.Longest Increasing subsequence 的followup, 输出最⻓长的所有元素
    static List<Integer> LIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> from = new HashMap<>();

        int len = 1;
        int[] seq = new int[nums.length];
        seq[0] = nums[0];
        int last = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < seq[0]) {
                //less than smallest one
                seq[0] = nums[i];
            } else if (nums[i] > seq[len-1]) {
                //larger than the largest one
                seq[len] = nums[i];
                last = nums[i];
                from.put(seq[len], seq[len-1]);
                len++;
            } else {
                int idx = binarySearch(seq, len, nums[i]);
                seq[idx] = nums[i];
                from.put(seq[idx], seq[idx-1]);
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(last);
        while (from.containsKey(last)) {
            last = from.get(last);
            ans.add(last);
        }

        Collections.reverse(ans);
        return ans;
    }

    static int binarySearch(int[] nums, int hi, int target) {
        int lo = 0;

        while (lo < hi) {
            int mi = (lo + hi) / 2;

            if (target == nums[mi]) {
                return mi;
            } if (target > nums[mi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return lo;
    }


    static List<Integer> LIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> routes = new ArrayList<>();
        int len = 1;
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        routes.add(Arrays.asList(nums[0]));

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < tails[0]) {
                //less than smallest one
                tails[0] = nums[i];
                routes.get(0).set(0, nums[i]);
            } else if (nums[i] > tails[len-1]) {
                //larger than the largest one
                tails[len] = nums[i];
                routes.add(new ArrayList<>(routes.get(len - 1)));
                routes.get(len).add(nums[i]);
                len++;
            } else {
                int idx = binarySearch(tails, len, nums[i]);
                tails[idx] = nums[i];
                routes.get(idx).set(idx, nums[i]);
            }
        }

        return routes.get(routes.size()-1);
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {3, 5, 1, 7, 4, 9};
        int[] nums = new int[] {3, 5, 1, 7, 6, 4, 9, 2, 10, 12};
        System.out.println(LIS2(nums));
    }
}
