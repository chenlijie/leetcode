package ebay;

import utility.Utils;

import java.util.Random;

public class EquallyRandom {

    /**
     *
     * k/i * i/(i+1) * (i+1)/(i+2) ... (n-1)/n = k/n
     *
     *
     *
     */

    static int[] randomNumbers(int[] nums, int k) {

        int[] ans = new int[k];

        int len = nums.length;
        int i = 0;
        for (; i < k; i++) {
            ans[i] = nums[i];
        }

        Random r = new Random();
        for (int j = k; j < len; j++) {
            int idx = r.nextInt(j + 1);

            if (idx < k)
                ans[idx] = nums[j];
        }

        Utils.printArray(ans);

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 1, 5, 6, 7, 8, 9, 11, 15, 12, 20, 13};
        randomNumbers(nums, nums.length);
    }
}
