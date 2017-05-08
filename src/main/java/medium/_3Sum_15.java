package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 4/17/17.
 */
public class _3Sum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        threeSum(all, new ArrayList<Integer>(), nums, 0);
        return all;
    }

    private void threeSum(List<List<Integer>> all, List<Integer> temp, int[] nums, int start) {
        if (temp.size() == 3) {
            int sum = 0;
            for (int num : temp) {
                sum += num;
            }
            if (sum == 0)
                all.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i-1]) continue;
                temp.add(nums[i]);
                threeSum(all, temp, nums, i+1);
                temp.remove(temp.size() -1);
            }
        }
    }


    public static void main(String[] args) {
        for (List<Integer> list : new _3Sum_15().threeSum(new int[]{-2, -1, 0, 1, 2, 3})) {
            System.out.println(list);
        }
    }
}
