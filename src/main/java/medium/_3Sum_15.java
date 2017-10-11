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

        for (int i = 0; i < nums.length; i++) {

            int j = i+1;
            int k = nums.length-1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    all.add(list);
                    j++;
                    k--;

                    while (j < k && j+1 < nums.length && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while (j < k && k < nums.length-1 && nums[k] == nums[k+1]) {
                        k--;
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }

            while (i < nums.length-2 && nums[i] == nums[i+1]) {
                i++;
            }
        }

        return all;
    }

    public static void main(String[] args) {
        for (List<Integer> list : new _3Sum_15().threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6})) {
            System.out.println(list);
        }
    }
}
