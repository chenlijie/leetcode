package facebook.fblist;

import java.util.HashSet;
import java.util.Set;

public class SubArraySum {

//    给定⼀一个数组和⼀一个⽬目标值，数组中均为正数，要求找出数组中是否含有⼀一个连续⼦子数组的和，
//    等于⽬目标值，返回true or false
//    follow up 数组中包含负数该如何修改
//    答：全部是正数的时候可以⽤用two pointer做到时空最优，因为sum是递增的；但是如果 有负数的话
//    就只能⽤用hashmap

    static boolean subSum(int[] nums, int t) {
        if (nums == null || nums.length == 0)
            return false;

        int len = nums.length;
        int sum = 0;

        for (int i = 0, j = 0; i < len; i++) {
            sum += nums[i];

            if (sum == t) {
                return true;
            }

            while (sum > t && j <= i) {
                sum -= nums[j++];

                if (sum == t)
                    return true;
            }
        }
        return false;
    }

    static boolean subSum2(int[] nums, int t) {
        if (nums == null || nums.length == 0)
            return false;

        Set<Integer> sums = new HashSet<>();

        int sum = 0;
        sums.add(0);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sums.contains(sum - t)) {
                return true;
            }

            sums.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(subSum2(new int[] {1,2,-1}, 0));
    }
}
