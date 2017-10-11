package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 4/25/17.
 */
public class _4Sum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> all = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {

            for (int n = i+1; n < nums.length; n++) {
                int j = n+1;
                int k = nums.length-1;

                while (j < k) {
                    if (nums[i] + nums[n] + nums[j] + nums[k] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[n]);
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
                    } else if (nums[i] + nums[n] + nums[j] + nums[k] < target) {
                        j++;
                    } else {
                        k--;
                    }
                }

                while (n < nums.length-2 && nums[n] == nums[n+1]) {
                    n++;
                }
            }

            while (i < nums.length-3 && nums[i] == nums[i+1]) {
                i++;
            }
        }

        return all;
    }


    public static void main(String[] args) {
//        for (List<Integer> list : new _4Sum_18().fourSum2(new int[]{-5,-4,-3,-2,-1,0,0,0,0,1,2,3,4,5}, 0)) {
//        for (List<Integer> list : new _4Sum_18().fourSum3(new int[]{1,0,-1,0,-2,2}, 0)) {
        for (List<Integer> list : new _4Sum_18().fourSum(new int[]{1,0,-1,0,-2,2}, 0)) {
            System.out.println(list);

        }
    }
}
