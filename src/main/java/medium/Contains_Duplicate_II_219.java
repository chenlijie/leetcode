package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 9/7/17.
 */
public class Contains_Duplicate_II_219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }
}
