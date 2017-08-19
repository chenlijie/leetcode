package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 8/15/17.
 */
public class Combination_Sum_III_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combs = new ArrayList<>();

        backTracking(1, k, n, combs, new ArrayList<>());
        return combs;
    }

    private void backTracking(int s, int k, int n, List<List<Integer>> combs, List<Integer> possible) {

        if (possible.size() == k) {
            if (sum(possible) == n) {
                combs.add(new ArrayList<>(possible));
            }
            return;
        }

        for (int i = s; i <= 9; i++) {
            possible.add(i);
            backTracking(i + 1, k, n, combs, possible);
            possible.remove(possible.size() - 1);
        }
    }

    private int sum(List<Integer> possible) {
        int sum = 0;
        for (int i : possible) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

        for (List<Integer> list : new Combination_Sum_III_216().combinationSum3(3, 9)) {

            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
