package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenlijie on 4/15/17.
 */
public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        backTrack(nums, all, new ArrayList<>());
        return all;
    }

    private void backTrack(int[] nums, List<List<Integer>> all, List<Integer> list) {
        if (list.size() == nums.length) {
            all.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            backTrack(nums, all, list);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> permute2(int[] num) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<>());
        for (int n : num) {
            int size = res.size();
            for (; size > 0; size--) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<>(r);
                    t.add(i, n);
                    res.add(t);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        for(List<Integer> list : new Permutations_46().permute2(new int[]{1,2,3})) {
            System.out.println(list);
        }
    }
}