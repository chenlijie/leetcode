package linkedin;

/**
 * Created by chenlijie on 12/16/17.
 */
public class Count_the_number_of_occurrences_of_an_element_in_a_sorted_array {

    static int search(int[] nums, int target) {
        return findLargest(nums, target) - findSmallest(nums, target);
    }

    static int findSmallest(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo+hi)/2;

            if (target > nums[mi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        System.out.println("small : " + lo);
        return lo;
    }

    static int findLargest(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo+hi)/2;

            if (target >= nums[mi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        System.out.println("large : " + lo);
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,1,1,4,4,4,4,5,6,7}, 0));
    }
}
