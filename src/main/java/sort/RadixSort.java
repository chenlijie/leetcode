package sort;

/**
 * Created by chenlijie on 9/4/17.
 */
public class RadixSort {

    public void sort(int[] nums) {

        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            maxNum = Math.max(maxNum, nums[i]);
        }

        for (int i = 1; maxNum/i > 0; i*=10) {
            sort(nums, i);
        }
    }

    private void sort(int[] nums, int exp) {
        int base = 10;
        int[] count = new int[base];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]/exp%base]++;
        }

        for (int i = 1; i < base; i++) {
            count[i] += count[i-1];
        }

        int[] output = new int[nums.length];
        for (int i = nums.length-1; i >= 0; i--) {
            output[--count[nums[i]/exp%base]] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 114, 13, 21, 17, 5, 2};
        new RadixSort().sort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }
}
