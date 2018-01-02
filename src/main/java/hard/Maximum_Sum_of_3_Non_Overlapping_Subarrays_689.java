package hard;

/**
 * Created by chenlijie on 12/17/17.
 */
public class Maximum_Sum_of_3_Non_Overlapping_Subarrays_689 {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }

        int[] idx = new int[3];
        for (int i = 0; i < 3; i++) {
            idx[i] = i*k;
        }
        backTracking(nums, 0, k, 3, new int[3], sums, idx);
        return idx;
    }

    void backTracking(int[] nums, int start, int k, int e, int[] curIdx, int[] sums, int[] idx) {
        if (e == 0) {
            int max = getSumOf3Sub(idx, sums, k);
            int curVal = getSumOf3Sub(curIdx, sums, k);
            if (curVal > max) {
                copyValues(curIdx, idx);
            }
            return;
        }

        for (int i = start; i <= nums.length - e*k; i++) {
            curIdx[3-e] = i;
            backTracking(nums, i + k, k, e - 1, curIdx, sums, idx);
        }
    }

    void copyValues(int[] src, int[] des) {
        for (int i = 0; i < src.length; i++) {
            des[i] = src[i];
        }
    }

    int getSumOf3Sub(int[] idx, int[] sums, int k) {
        int total = 0;
        for (int i = 0; i < idx.length; i++) {
            total += sums[idx[i] + k] - sums[idx[i]];
        }
        return total;
    }
}
