package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 12/17/17.
 */
public class ProductOfPrimeNumber {

    static List<Integer> getProducts(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        backTracking(nums, 0, 1, ans);
        return ans;
    }

    static void backTracking(int[] nums, int i, int p, List<Integer> ans) {
        for (int j = i; j < nums.length; j++) {
            ans.add(p*nums[j]);
            backTracking(nums, j+1, p*nums[j], ans);
        }
    }

    public static void main(String[] args) {
        System.out.println(getProducts(new int[]{2, 5, 11}));
    }
}
