package medium;

import java.util.*;

/**
 * Created by chenlijie on 5/14/17.
 */
public class Top_K_Frequent_Elements_347 {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i])+1);
            max = Math.max(map.get(nums[i]), max);
        }

        final int s = Math.min(max, k);

        List<Integer> list = new ArrayList<>();
        map.forEach((key, value) -> {
            if (value >= s) {
                list.add(key);
            }
        });
        return list;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1,2}, 2));
    }
}
