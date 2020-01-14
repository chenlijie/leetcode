package zillow;

public class FindMedia {

//    Given  a sorted array of integers.
//      Find the median of the items that greater than or equal to an threashold.
//    int find_median( int[] array, int threashold)
//
//    For example:
//    array = [ 1, 2, 3, 4, 5, 6, 7, 8, 9]
//    threashold = 5
//            return median = 7

    static int find(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (nums[mi] >= k) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 5));
    }
}
