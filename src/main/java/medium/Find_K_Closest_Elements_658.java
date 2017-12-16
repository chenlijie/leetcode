package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 9/3/17.
 */
public class Find_K_Closest_Elements_658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int idx = findIndex(arr, x);
        return extendRange(arr, idx, k);
    }

    List<Integer> extendRange(int[] nums, int from, int k) {
        List<Integer> result = new ArrayList<>();

        int i = from - 1;
        int j = from;

        while (k > 0) {
            if (i >= 0 && j < nums.length) {
                if (k - nums[i] < nums[j] - k) {
                    result.add(nums[i--]);
                } else {
                    result.add(nums[j++]);
                }
            } else if (i < 0) {
                result.add(nums[j++]);
            } else {
                result.add(nums[i--]);
            }
        }

        return result;
    }

    int findIndex(int[] nums, int k) {
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

    public static void main(String[] args) {
        Find_K_Closest_Elements_658 k = new Find_K_Closest_Elements_658();
        for (int i : k.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3)) {
            System.out.print(i + "  ");
        }

    }
}
