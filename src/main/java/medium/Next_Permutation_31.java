package medium;

import java.util.Arrays;

/**
 * Created by chenlijie on 8/7/17.
 */
public class Next_Permutation_31 {

    public static void nextPermutation(int[] nums) {

        for (int i = nums.length-2; i >= 0; i--) {

            for (int j = nums.length-1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    nums[j] = nums[j]^nums[i];
                    nums[i] = nums[i]^nums[j];
                    nums[j] = nums[j]^nums[i];

                    int m = i+1;
                    int n = nums.length-1;
                    while (m < n) {
                        nums[m] = nums[m]^nums[n];
                        nums[n] = nums[n]^nums[m];
                        nums[m] = nums[m]^nums[n];
                        m++;
                        n--;
                    }
                    return;
                }
            }
        }

        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{1,3,2});
    }
}
