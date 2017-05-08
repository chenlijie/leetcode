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
        fourSum(nums, target, 0, new ArrayList<Integer>(), all);

        return all;
    }

    private void fourSum(int[] nums, int target, int start, List<Integer> possible, List<List<Integer>> all) {

        if (possible.size() == 4 && (target == possible.get(0)+possible.get(1)+possible.get(2)+possible.get(3))) {
            if (all.size() != 0) {
                List<Integer> temp = all.get(all.size()-1);
                if (!(temp.get(0).equals(possible.get(0))
                        && temp.get(1).equals(possible.get(1))
                        && temp.get(2).equals(possible.get(2))
                        && temp.get(3).equals(possible.get(3))))
                    all.add(new ArrayList<Integer>(possible));
            } else {
                all.add(new ArrayList<Integer>(possible));
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            possible.add(nums[i]);
            fourSum(nums, target, i+1, possible, all);
            int removed = possible.remove(possible.size()-1);
            while(i < nums.length-1 && removed == nums[i+1]) {
                i++;
            }
        }
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> all = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                for (int k = j+1; k < nums.length-1; k++) {
                    for (int l = k+1; l < nums.length; l++) {
                        if (target == nums[i]+nums[j]+nums[k]+nums[l]) {
                            all.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            break;
                        } else if (target < nums[i]+nums[j]+nums[k]+nums[l]) {
                            break;
                        }
                        while (l < nums.length-1 && nums[l]==nums[l+1]) l++;
                    }
                    while (k < nums.length-2 && nums[k]==nums[k+1]) k++;
                }
                while (j < nums.length-3 && nums[j]==nums[j+1]) j++;
            }
            while (i < nums.length-4 && nums[i]==nums[i+1]) i++;
        }

        return all;
    }

    public List<List<Integer>> fourSum3(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> all = new ArrayList<List<Integer>>();

        for (int i = 0, j = i+1, k = j+1, l = k+1; i < nums.length-3 ;) {
            /*if (target == nums[i]+nums[j]+nums[k]+nums[l]) {
                all.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                while (k < nums.length-3 && nums[k] == nums[k+1]) {
                    k++;
                }
                k++;
                l = k+1;
                continue;
            } else*/ if (target <= nums[i]+nums[j]+nums[k]+nums[l]) {
                if (target == nums[i]+nums[j]+nums[k]+nums[l]) {
                    all.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                }

                while (k < nums.length-3 && nums[k] == nums[k+1]) {
                    k++;
                }
                k++;
                l = k+1;

                if (k < nums.length-3) {
                    continue;
                } else {
                    while (j < nums.length-4 && nums[j] == nums[j+1]) {
                        j++;
                    }
                    j++;
                    k = j+1;
                    l = k+1;
                    if (j < nums.length-4) {
                        continue;
                    } else {
                        while (i < nums.length-5 && nums[i] == nums[i+1]) {
                            i++;
                        }
                        i++;
                        j = i+1;
                        k = j+1;
                        l = k+1;
                    }
                }

            } else {
                while (l < nums.length-1 && nums[l] == nums[l+1]) {
                    l++;
                }
                l++;
                continue;
            }
        }
        return all;
    }

    public static void main(String[] args) {
//        for (List<Integer> list : new _4Sum_18().fourSum2(new int[]{-5,-4,-3,-2,-1,0,0,0,0,1,2,3,4,5}, 0)) {
        for (List<Integer> list : new _4Sum_18().fourSum3(new int[]{1,0,-1,0,-2,2}, 0)) {
//        for (List<Integer> list : new _4Sum_18().fourSum3(new int[]{1,0,-1,0}, 0)) {
            System.out.println(list);

        }
    }
}
