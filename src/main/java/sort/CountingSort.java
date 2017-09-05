package sort;

/**
 * Created by chenlijie on 9/4/17.
 */
public class CountingSort {

    public void sort(int[] nums) {

        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n = Math.max(n, nums[i]+1);
        }

        int[] count = new int[n];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 1; i < n; i++) {
            count[i] += count[i-1];
        }

        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[--count[nums[i]]] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 1, 2, 7, 5, 2};
        new CountingSort().sort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
