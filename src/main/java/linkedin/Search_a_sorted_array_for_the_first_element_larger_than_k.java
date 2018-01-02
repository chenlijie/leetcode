package linkedin;

/**
 * Created by chenlijie on 12/16/17.
 */
public class Search_a_sorted_array_for_the_first_element_larger_than_k {

    static int search(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo+hi)/2;

            if (nums[mi] > k) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        return lo == nums.length ? -1 : nums[lo];
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 4, 7}, 10));
    }
}
