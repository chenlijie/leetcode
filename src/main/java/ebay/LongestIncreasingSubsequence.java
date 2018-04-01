package ebay;

public class LongestIncreasingSubsequence {


    static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] tails = new int[len];
        int lastIdx = 0;

        for (int i = 0; i < len; i++) {
            int idx = find(nums, nums[i], lastIdx);

            if (idx >= lastIdx) {
                tails[lastIdx++] = nums[i];
            } else {
                tails[idx] = nums[i];
            }
        }

        return lastIdx;
    }

    static int find(int[] nums, int t, int hi) {
        int lo = 0;

        while (lo < hi) {
            int mi = (lo + hi) / 2;

            if (nums[mi] >= t) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        lengthOfLIS(new int[] {2,5,3,7,101,18});
    }
}

