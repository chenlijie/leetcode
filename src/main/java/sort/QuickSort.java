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

    public void quickSelectSort(int[] nums) {
        sortUtils(nums, 0, nums.length - 1);
    }

    private void sortUtils(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = nums[end];

            int j = 0;
            for (int i = 0; i < end; i++) {
                if (nums[i] >= pivot) {
                    swap(nums, i, j++);
                }
            }

            swap(nums, j, end);
            sortUtils(nums, start, j - 1);
            sortUtils(nums, j + 1, end);
        }

    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        new QuickSort().quickSelectSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
