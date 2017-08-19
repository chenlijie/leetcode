package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 8/17/17.
 */
public class Majority_Element_169 {

    public int majorityElement(int[] nums) {

        int major = nums.length/2;

        Map<Integer, Integer> counts = new HashMap<>();

        for (int i : nums) {

            counts.put(i, counts.getOrDefault(i, 0) + 1);

            if (counts.get(i) > major) {
                return i;
            }
        }

        return -1;
    }
}
