package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 8/8/17.
 */
public class Combination_Sum_II_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> combs = new ArrayList<>();
        combinationSum2(candidates, target, 0, new ArrayList<>(), combs);

        return combs;
    }

    private int combinationSum2(int[] candidates, int target, int start, List<Integer> possible, List<List<Integer>> combs) {

        if (target == 0) {
            combs.add(new ArrayList<>(possible));
            return -1;
        }

        if (target < 0) {
            return -1;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            possible.add(candidates[i]);
            int result = combinationSum2(candidates, target-candidates[i], i+1, possible, combs);
            possible.remove(possible.size()-1);

            if (result == -1) {
                break;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] candidates = new int[] {10, 1, 2, 7, 6, 1, 5, 1};
        for (List<Integer> comb : new Combination_Sum_II_40().combinationSum2(candidates, 8)) {
            for (int i : comb) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
