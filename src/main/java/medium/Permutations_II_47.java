package medium;

import java.util.*;

/**
 * Created by chenlijie on 8/2/17.
 */
public class Permutations_II_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> results = new HashSet<>();
        permute(results, nums, 0);
        return new ArrayList<>(results);
    }

    void permute(Set<List<Integer>> results, int[] num, int next) {
        if (num.length == next) {
            List<Integer> result = new ArrayList<>();
            for (int i : num) {
                result.add(i);
            }
            results.add(result);
            return;
        }

        for (int i = next; i < num.length; i++) {
            if (i > next && num[i] == num[next])
                continue;
            swap(num, next, i);
            permute(results, num, next + 1);
            swap(num, next, i);
        }
    }

    void swap(int[] num, int next, int i) {
        int t = num[next];
        num[next] = num[i];
        num[i] = t;
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {

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
        System.out.println(new Permutations_II_47().permuteUnique(new int[]{1,1,1,1}));
    }
}
