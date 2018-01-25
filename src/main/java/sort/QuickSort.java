package sort;

/**
 * Created by chenlijie on 9/4/17.
 */
public class QuickSort {


    public void quickSort(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        quickUtils(nums, lo, hi);
    }

    void quickUtils(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int pivot = nums[hi];

            int j = 0;
            for (int i = 0; i < hi; i++) {
                if (nums[i] <= pivot) {
                    swap(nums, i, j);
                    j++;
                }
            }

            swap(nums, j, hi);

            quickUtils(nums, lo, j-1);
            quickUtils(nums, j + 1, hi);
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,3,6,4,3};
        new QuickSort().quickSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
