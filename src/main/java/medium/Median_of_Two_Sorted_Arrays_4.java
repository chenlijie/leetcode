package medium;

/**
 * Created by chenlijie on 9/6/17.
 */
public class Median_of_Two_Sorted_Arrays_4 {

    /**
     *    0   1   2   3   4   5   6   7
     * A  1   3   6
     * B  2   4   5   7   8   9   10  11
     *
     * Length of A is m and B is n. If merge array A and B, the median element is at (m+n)/2.
     * If we can find one element that its index in A plus its index in B is (m+n)/2. It is the right element.
     * eg: 6 is the median element and (m+n)/2 is 5, it is in 2nd place of A and 3rd place of B.
     *
     * The median element is either in A or B. Let's assume it is in A, we can do following step to try to find it.
     * 1. Take middle element from A, so the index from A is (low+high)/2 as middle. (At first, low is 0 and high is m).
     * 2. Do binary search on element A[middle] in array B to get the index from B as indexB.
     *    1) If middle + indexB equals (m+n)/2, we find the right element.
     *    2) If middle + indexB less than (m+2)/2, we need a bigger element and set low as middle.
     *       Else we need a smaller element ans set high as middle. Repeat step 1 and 2.
     *
     * If we don't find the element, the element is must in B. we can do same for array B.
     *
     * There are 2 loops here, the first loop always take middle element so time complexity is O(logm),
     * the second loop is do binary search so time complexity is O(logn). The final complexity is
     * O(logm*logn)
     *
     * If m+n is odd, find index (m+n)/2 among array A and B; else find index (m+n)/2 and ((m+n)/2)-1
     *
     * odd:
     * targetIndex = (m+n)/2
     * lowA = 0
     * highA = A.length
     * for midIndex <- (lowA+highA)/2
     *     indexInB = binarySearch A[mid] in B[n]
     *     if midIndex+indexInB = targetIndex
     *        return A[midIndex]
     *     if midIndex+indexInB < targetIndex
     *        lowIndex = midIndex + 1
     *     else
     *        highIndex = midIndex
     *
     *
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;

        if (n % 2 == 1) {
            int t = find(nums1, nums2, n/2, true);
            return  t == -1 ? find(nums2, nums1, n/2, false) : t;
        } else {
            int t1 = find(nums1, nums2, n/2 - 1, true);
            int t2 = find(nums1, nums2, n/2, true);

            if (t1 == -1) {
                t1 = find(nums2, nums1, n/2 - 1, false);
            }
            if (t2 == -1) {
                t2 = find(nums2, nums1, n/2, false);
            }

            return (t1 + t2) / 2.0;
        }
    }

    private int find(int[] nums1, int[] nums2, int targetIndex, boolean flag) {
        int low1 = 0;
        int high1 = nums1.length;

        while (low1 < high1) {
            int middle1 = low1 + (high1-low1)/2;

            int index2 = binarySearch(nums1[middle1], nums2, flag);

            if (middle1 + index2 == targetIndex) {
                return nums1[middle1];
            }

            if (middle1 + index2 < targetIndex) {
                low1 = middle1 + 1;
            } else {
                high1 = middle1;
            }
        }

        return -1;
    }

    private int binarySearch(int target, int[] nums, boolean flag) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int middle = low + (high-low)/2;

            if ((target > nums[middle] && flag) || (target >= nums[middle] && !flag)) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }

        return low;
    }

    public static void main(String[] args) {
//        System.out.println(new Median_of_Two_Sorted_Arrays_4().binarySearch(2, new int[] {1, 3, 6}));

//        int[] nums1 = new int[] {1, 3, 6};
//        int[] nums2 = new int[] {2, 4, 5, 7, 8, 9, 10, 11, 12};

        int[] nums1 = new int[] {1, 1};
        int[] nums2 = new int[] {1, 1};
        System.out.println(new Median_of_Two_Sorted_Arrays_4().findMedianSortedArrays(nums1, nums2));
    }
}
