package facebook.fblist;

import java.util.*;

public class APlusBEqualsCPlusD {

    List<List<Integer>> getIndices(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<List<Integer>>> indices = new HashMap<>();

        int len = nums.length;

        for (int i = 0; i < len-1; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = nums[i] + nums[j];

            }
        }
        return null;
    }
}
