package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 8/2/17.
 */
public class Permutations_II_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> permute = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
        backTracking(permute, combo, nums, new boolean[nums.length]);
        return permute;
    }

    private void backTracking(List<List<Integer>> permute, List<Integer> combo, int[] num, boolean[] visited) {
        if (combo.size() == num.length) {
            permute.add(new ArrayList<>(combo));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && combo.size() == 0 && num[i] == num[i-1]) {
                continue;
            }

            combo.add(num[i]);
            visited[i] = true;
            backTracking(permute, combo, num, visited);
            combo.remove(combo.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations_II_47().permuteUnique(new int[]{3,3,0,0,2,3,2}));
    }
}
