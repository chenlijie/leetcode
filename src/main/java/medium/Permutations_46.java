package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by chenlijie on 4/15/17.
 */
public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, 0, nums.length - 1, results);
        return results;
    }

    void permute(int[] nums, int l, int r, List<List<Integer>> results) {
        if (l >= r) {
            List<Integer> temp = new ArrayList<>();
            for (int n : nums) {
                temp.add(n);
            }
            results.add(temp);
            return;
        }

        for (int i = l; i <= r; i++) {
            swap(nums, l, i);
            permute(nums, i+1, r, results);
            swap(nums, l, i);
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    int c = 1;


    public static void main(String[] args) {
        for(List<Integer> list : new Permutations_46().permute(new int[]{1,2,3})) {
            System.out.println(list);
        }
    }
}