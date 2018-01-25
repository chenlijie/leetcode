package medium;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberProduct {

    //给⼀一个质数数组（⽆无重复），输出数组元素所有可能的乘积
    static List<Integer> getProducts(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            helper(nums, i+1, nums[i], ans);//implement late
        }
        return ans;
    }

    static void helper(int[] nums, int start, int pre, List<Integer> ans) {

        for (int i = start; i < nums.length; i++) {
            ans.add(pre * nums[i]);
            helper(nums, i + 1, pre * nums[i], ans);
        }
    }

    public static void main(String[] args) {
        System.out.println(getProducts(new int[] {3,5,7,11}));
    }
}
