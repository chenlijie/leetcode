package sort;

/**
 * Created by chenlijie on 9/4/17.
 */
public class QuickSort {


    public void sort(int[] nums) {
        int lo = 0;
        int hi = nums.length;

        sortUtil2(nums, lo, hi-1);
    }

    //select last element as pivot
    private void sortUtil(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int pivot = nums[hi];

            int j = lo;
            for (int i = lo; i < hi; i++) {

                if (nums[i] < pivot) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    j++;
                }
            }

            nums[hi] = nums[j];
            nums[j] = pivot;

            sortUtil(nums, lo, j-1);
            sortUtil(nums, j+1, hi);
        }
    }

    //select middle element as pivoit
    private void sortUtil2(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int mi = lo + (hi-lo)/2;
            int pivot = nums[mi];

            int j = lo;
            for (int i = lo; i <= hi; i++) {

                if (nums[i] < pivot) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    j++;
                }
            }

            nums[hi] = nums[j];
            nums[j] = pivot;

            sortUtil(nums, lo, j-1);
            sortUtil(nums, j+1, hi);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 5, 2, 3};
        new QuickSort().sort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
