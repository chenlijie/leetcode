package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenlijie on 12/8/17.
 */
public class Two_Sum_III_170 {
    static class TwoSum {

        List<Integer> nums;
        /** Initialize your data structure here. */
        public TwoSum() {
            nums = new ArrayList<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            nums.add(number);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            Set<Integer> set = new HashSet<>();

            int size = nums.size();
            for (int i = 0; i < size; i++) {
                if (set.contains(value-nums.get(i))) {
                    return true;
                }
                set.add(nums.get(i));
            }
            return false;
        }
    }
}
