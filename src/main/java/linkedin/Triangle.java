package linkedin;

import java.util.Arrays;

/**
 * Created by chenlijie on 12/12/17.
 */
public class Triangle {

    // e < a <= b <= c
    // a + b > c
    // e + b > c => a + b > c
    static boolean canMakeTriangle(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 2; i < len; i++) {
            if (nums[i-2] + nums[i-1] > nums[i]) {
                System.out.println(nums[i-2] + "+" + nums[i-1] + ">" + nums[i]);
                return true;
            }
        }
        return false;
    }

    static int countTriangle(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        int cnt = 0;

        for (int i = len-1; i >= 2; i--) {
            for (int j = i-1; j >= 1; j--) {
                int c = nums[i];
                int b = nums[j];
                int a = c - b;

                int idx = binarySearch(nums, j, a);
                cnt += j - idx;
            }
        }

        System.out.println(cnt);
        return cnt;
    }

    static int binarySearch(int[] nums, int hi, int t) {
        int lo = 0;

        while (lo < hi) {
            int mi = (lo + hi)/2;

            if (nums[mi] <= t) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        countTriangle(new int[] {5,7,8,10});
//        System.out.println(canMakeTriangle(new int[]{1,2,4,6,9}));
//        System.out.println(canMakeTriangle(new int[]{1,3,3,6,8}));
//        System.out.println(canMakeTriangle(new int[]{1,2,3,5,8}));
    }
}
