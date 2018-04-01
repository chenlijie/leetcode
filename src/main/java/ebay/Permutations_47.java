package ebay;

import java.util.*;

public class Permutations_47 {

    static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        // List<List<Integer>> ans = new ArrayList<>();
        // helper(nums, 0, ans);
        // backTracking(nums, new boolean[len], new ArrayList<>(), ans);

        LinkedList<List<Integer>> ans = new LinkedList<>();
        ans.offer(new ArrayList<>());

        for (int num : nums) {
            int size = ans.size();

            Set<List<Integer>> set = new HashSet<>();
            while (size-- >= 0) {

                List<Integer> p = ans.poll();

                for (int i = 0; i <= p.size(); i++) {
                    List<Integer> list = new ArrayList<>(p);
                    list.add(i, num);
                    set.add(list);
                }
            }
            ans.addAll(set);
        }

        return ans;
    }

    public static void main(String[] args) {
        permuteUnique(new int[] {1, 1, 2});
    }
}
