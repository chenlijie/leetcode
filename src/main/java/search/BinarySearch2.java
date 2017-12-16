package search;

/**
 * Created by chenlijie on 8/14/17.
 */
public class BinarySearch2 {

    public static int search(int[] source, int target) {

        int low = 0;
        int high = source.length;

        while (low < high) {

            int middle = low + (high-low)/2;

            if (source[middle] == target) {
                return middle;
            } else if (source[middle] > target) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }

        System.out.println(high);
        return low;
    }

    public static void main(String[] args) {

//        System.out.println(search(new int[] {1}, 0));
//        System.out.println(search(new int[] {1, 2}, 1) == 0);
//        System.out.println(search(new int[] {1, 2}, 3) == 2);
//        System.out.println(search(new int[] {1, 2, 4}, -1) == 0);
//        System.out.println(search(new int[] {1, 4, 8}, 2) == 1);
//        System.out.println(search(new int[] {1, 2, 4}, 1) == 0);
//        System.out.println(search(new int[] {1, 2, 4}, 2) == 1);
//        System.out.println(search(new int[] {1, 2, 4}, 4) == 2);
//        System.out.println(search(new int[] {1, 2, 4}, 3) == 2);
//        System.out.println(search(new int[] {1, 2, 4}, 13) == 3);
//        System.out.println(search(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 3) == 2);
//        System.out.println(search(new int[] {1}, 2) == -1);
//        System.out.println(search(new int[] {1}, 0) == -1);
//        System.out.println(search(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 0) == -1);
//        System.out.println(search(new int[] {1, 2, 3, 5, 6, 7, 8}, 9) == 4);

        System.out.println(findIndex(new int[]{1,3}, 10));
    }

    static int findIndex(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo + hi)/2;

            if (nums[mi] >= k) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        return lo;
    }
}
