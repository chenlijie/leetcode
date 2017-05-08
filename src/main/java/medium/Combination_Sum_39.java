package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 4/14/17.
 */
public class Combination_Sum_39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        collect(list, new ArrayList<Integer>(), candidates, candidates.length, target, 0);

        return  list;
    }

    static void collect(List<List<Integer>> list, List<Integer> nums, int[] candidates, int len, int target, int start) {
        if (0 == target) {
            list.add(nums);
            return;
        }

        if (0 > target) {
            return;
        }

        for (int i = start; i < len; i++) {
            List<Integer> newList = new ArrayList<Integer>();
            newList.addAll(nums);
            newList.add(candidates[i]);
            collect(list, newList, candidates, len, target-candidates[i], i);
        }
    }
}
