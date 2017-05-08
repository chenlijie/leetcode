package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 4/26/17.
 */
public class Two_Sum_1 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target-nums[i])) {
                res[1] = i;
                res[0] = map.get(target-nums[i]);
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] res = new Two_Sum_1().twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
