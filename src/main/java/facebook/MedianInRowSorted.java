package facebook;

/**
 * Created by chenlijie on 12/19/17.
 */
public class MedianInRowSorted {

    /*
    Time Complexity: O(32 * r * log(c)).
    The upper bound function will take log(c) time and is performed for each row.
    And since the numbers will be max of 32 bit,
    so binary search of numbers from min to max will be performed in
    at most 32 ( log2(2^32) = 32 ) operations.
     */

    static int binaryMedian(int[][] m) {
        int r = m.length;
        int c = m[0].length;

        //find min
        int min = m[0][0];
        for (int i = 0; i < r; i++) {
            min = Math.min(min, m[i][0]);
        }
        //find max
        int max = m[0][c-1];
        for (int i = 0; i < r; i++) {
            max = Math.max(max, m[i][c-1]);
        }
        //median has desired num less than it
        int desired = (r * c + 1)/2;

        while (min < max) {
            int mid = min + (max - min) / 2;
            int cnt = 0;

            for (int i = 0; i < r; i++) {
                //To get how many nums less than or equal to mid
                cnt += getTotalNoMoreThanK(m[i], mid);
            }

            if (cnt < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    static int getTotalNoMoreThanK(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = lo + (hi-lo)/2;

            if (nums[mi] <= k) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[][] m = new int[][] {
                {1,400,401},
                {402,403,404},
                {405,406,407}
//                {1,2,3,4,5}
        };
        System.out.println(binaryMedian(m));
    }
}
