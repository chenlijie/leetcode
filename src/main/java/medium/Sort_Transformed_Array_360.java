package medium;

import utility.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenlijie on 11/8/17.
 */
public class Sort_Transformed_Array_360 {

    static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null) {
            return null;
        }

        int[] result = new int[nums.length];

        if (a == 0) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = func(nums[i], a, b, c);
            }
            return result;
        }

        int target = -b/2/a + 1;
        int start = binarySearch(nums, target);

        if (a > 0) {
            int i = start - 1;
            int j = start;
            int k = 0;

            while (i >= 0 && j <nums.length) {
                int x = func(nums[i], a, b, c);
                int y = func(nums[j], a, b, c);
                if (x < y) {
                    result[k++] = x;
                    i--;
                } else {
                    result[k++] = y;
                    j++;
                }
            }

            for (int n = i; n >= 0; n--) {
                result[k++] = func(nums[n], a, b, c);
            }

            for (int n = j; n < nums.length; n++) {
                result[k++] = func(nums[n], a, b, c);
            }
        } else {
            int i = start - 1;
            int j = start;
            int k = nums.length - 1;

            while (i >= 0 && j <nums.length) {
                int x = func(nums[i], a, b, c);
                int y = func(nums[j], a, b, c);
                if (x > y) {
                    result[k--] = x;
                    i--;
                } else {
                    result[k--] = y;
                    j++;
                }
            }

            for (int n = i; n >= 0; n--) {
                result[k--] = func(nums[n], a, b, c);
            }

            for (int n = j; n < nums.length; n++) {
                result[k--] = func(nums[n], a, b, c);
            }
        }

        return result;
    }

    static int func(int num, int a, int b, int c) {
        return a * (int)Math.pow(num, 2) + b * num + c;
    }

    static int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mi = (lo + hi)/2;

            if (target <= nums[mi]) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
//        System.out.println(binarySearch(new int[]{1, 3, 5, 7}, -1));
//        System.out.println(binarySearch(new int[]{1, 3, 5, 7}, 1));
//        System.out.println(binarySearch(new int[]{1, 3, 5, 7}, 2));
//        System.out.println(binarySearch(new int[]{1, 3, 5, 7}, 3));
//        System.out.println(binarySearch(new int[]{1, 3, 5, 7}, 5));
//        System.out.println(binarySearch(new int[]{1, 3, 5, 7}, 6));
//        System.out.println(binarySearch(new int[]{1, 3, 5, 7}, 7));
//        System.out.println(binarySearch(new int[]{1, 3, 5, 7}, 8));
        Utils.printArray(sortTransformedArray(new int[]{-4, -2, 2, 4}, -1, 3, 5));

        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(1,2,3);
        set.add(list1);
        set.add(list2);
        System.out.println(set.size());
    }
}
