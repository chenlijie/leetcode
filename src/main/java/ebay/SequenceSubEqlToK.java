package ebay;

import java.util.*;

public class SequenceSubEqlToK {

    static List<List<Integer>> subEqlToK(int[] nums, int k) {

        //key : sub sum, value : sub array end idx
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {

                for (int start : map.get(sum - k)) {
                    List<Integer> list = new ArrayList<>();

                    for (int j = start + 1; j <= i; j++) {
                        list.add(nums[j]);
                    }
                    ans.add(list);
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        for (List<Integer> l : ans) {
            System.out.println(l);
        }

        return ans;
    }

    public static void main(String[] args) {
        subEqlToK(new int[] {1,0,1,2,0,3,1}, 3);
    }
}
