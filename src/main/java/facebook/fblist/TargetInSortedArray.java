package facebook.fblist;

import java.util.ArrayList;
import java.util.List;

public class TargetInSortedArray {

//    sorted的array中数target数⽬目
//    用LC34的⽅方法得到第⼀一个targer的位置和最后⼀一个target位置，时间O(logN)

    List<Integer> find(int[] nums, int t) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        int start = findFrist(nums, t);
        if (start == -1)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        int end = findLast(nums, t);
        ans.add(start);
        ans.add(end - 1);

        System.out.println(ans);
        return ans;
    }

    private int findFrist(int[] nums, int t) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo + hi) / 2;

            if (t > nums[mi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo == nums.length || nums[lo] != t ? -1 : lo;
    }

    private int findLast(int[] nums, int t) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo + hi) / 2;

            if (t >= nums[mi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        TargetInSortedArray t = new TargetInSortedArray();
        t.find(new int[] {1,1,1,2,3,3,3,3,4}, 3);
    }
}
