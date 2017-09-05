package sort;

/**
 * Created by chenlijie on 8/25/17.
 */
public class MergeSort {


    /**
     *
     *      If r > l
     *      1. Find the middle point to divide the array into two halves:
     *          middle m = (l+r)/2
     *      2. Call mergeSort for first half:
     *          Call mergeSort(arr, l, m)
     *      3. Call mergeSort for second half:
     *          Call mergeSort(arr, m+1, r)
     *      4. Merge the two halves sorted in step 2 and 3:
     *          Call merge(arr, l, m, r)
     *
     *
     *
     */
    public static void merge(int[] nums) {

        nums = merge(nums, 0, nums.length);

        for (int i : nums) {
            System.out.print(i + "  ");
        }
    }

    private static int[] merge(int[] nums, int start, int end) {
        if (start+1 == end) {
            return new int[]{nums[start]};
        }

        if (start >= end) {
            return new int[0];
        }

        int middle = (start+end)/2;

        //sort left half
        int[] left = merge(nums, start, middle);

        //sort right half
        int[] right = merge(nums, middle, end);

        //merge left and right half
        int i = 0;
        int j = 0;

        int[] result = new int[end-start];
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }


    public static void main(String[] args) {
        merge(new int[]{6});
    }
}
