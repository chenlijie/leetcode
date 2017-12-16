package medium;

import utility.Utils;

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

    public void nextPermutation2(int[] nums) {

        int end = nums.length-1;
        int i = end;
        for (; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                break;
            }
        }

        if (i == 0) {
            reverse(nums, 0, end);
            return;
        }

        int val = nums[i-1];

        int j = end;
        for (; j >=i; j--) {
            if (nums[j] > val) {
                break;
            }
        }

        swap(nums, i-1, j);
        reverse(nums, i, end);
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    void reverse(int[] nums, int s, int e) {
        while(s < e) {
            int t = nums[s];
            nums[s] = nums[e];
            nums[e] = t;
            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{1,3,2});

        int[] input = new int[]{1,3,2};
        new Next_Permutation_31().nextPermutation2(input);
        Utils.printArray(input);
    }
}
