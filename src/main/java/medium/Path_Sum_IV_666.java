package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 11/9/17.
 */
public class Path_Sum_IV_666 {

    static int pathSum(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i/10, i%10);
        }

        pathSum(nums[0]/10, map, 0);
        return sum;
    }

    static int sum = 0;

    static void pathSum(int root, Map<Integer, Integer> map, int preSum) {
        int left = (root/10*10 + 10) + 2*(root%10) - 1;
        int right = (root/10*10 + 10) + 2*(root%10);

        if (!map.containsKey(left) && !map.containsKey(right)) {
            sum += preSum + map.get(root);
        }
        if (map.containsKey(left)) {
            pathSum(left, map, preSum + map.get(root));
        }
        if (map.containsKey(right)){
            pathSum(right, map, preSum + map.get(root));
        }
    }


    public static void main(String[] args) {
        System.out.println(pathSum(new int[]{113, 215, 221}));
    }
}
