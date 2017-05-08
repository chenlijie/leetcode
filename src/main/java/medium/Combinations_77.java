package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 4/15/17.
 */
public class Combinations_77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        combine(list, new int[k], n, k, 1);
        return list;
    }

    private void combine(List<List<Integer>> all, int[] list, int n, int k, int s) {
        if (0 == k) {
            List<Integer> temp = new ArrayList<Integer>();
            int len = list.length-1;
            for (int i = len; i >= 0; i--) {
                temp.add(list[i]);
            }
            all.add(temp);
            return;
        }

        for (int i = s; i <= n; i++) {
            list[k-1] = i;
            combine(all, list, n, k-1, ++s);
        }
    }
}