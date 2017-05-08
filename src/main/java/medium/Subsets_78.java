package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenlijie on 4/16/17.
 */
public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        subsets(all, new ArrayList<Integer>(), nums, 0);
        return  all;
    }

    private void subsets(List<List<Integer>> all, List<Integer> temp, int[] nums, int start) {
        all.add(new ArrayList<Integer>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            subsets(all, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> subsets2(int[] S) {
        int totalNumber = 1 << S.length;
        List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
        for (int i=0; i<totalNumber; i++) {
            List<Integer> set = new LinkedList<Integer>();
            for (int j=0; j<S.length; j++) {
                if ((i & (1<<j)) != 0) {
                    set.add(S[j]);
                }
            }
            collection.add(set);
        }
        return collection;
    }

    public static void main(String[] args) {
        for(List<Integer> list : new Subsets_78().subsets2(new int[]{1,2,3})) {
            System.out.println(list);
        }
    }
}
