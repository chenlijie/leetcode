package medium;

import java.util.*;

/**
 * Created by chenlijie on 4/16/17.
 */
public class Subsets_II_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        subsetsWithDup(all, new ArrayList<Integer>(), nums, 0);
        return new ArrayList<List<Integer>>(all);
    }

    private void subsetsWithDup(List<List<Integer>> all, List<Integer> temp, int[] nums, int start) {
        all.add(new ArrayList<Integer>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            subsetsWithDup(all, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }

//    public List<List<Integer>> subsetsWithDup2(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> all = new ArrayList<List<Integer>>();
//
//        int len = nums.length;
//        for (int i = 0; i < len; i++) {
//            List<Integer> temp = new ArrayList<Integer>();
//            for (int j = i; j < len; j++) {
//
//            }
//        }
//
//        return all;
//    }

    public static void main(String[] args) {
        for(List<Integer> list : new Subsets_II_90().subsetsWithDup(new int[]{1,2,2,2})) {
            System.out.println(list);
        }
    }
}
