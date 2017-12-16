package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 4/28/17.
 */
public class House_Robber_198 {


    public int rob2(int[] nums) {

        int rob = 0;
        int notRob = 0;
        int current;
        for (int i = 0; i < nums.length; i++) {
            current = notRob + nums[i];
            notRob = Math.max(rob, notRob);
            rob = current;
        }
        return Math.max(rob, notRob);
    }

    static int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int[] rob = new int[nums.length];
        int[] notRob = new int[nums.length];
        rob[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            rob[i] = notRob[i-1] + nums[i];
            notRob[i] = Math.max(rob[i-1], notRob[i-1]);
        }
        return Math.max(rob[nums.length-1], notRob[nums.length-1]);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2}));

        Map<int[], Integer> map = new HashMap<>();
        map.put(new int[]{1,2}, 1);
        map.put(new int[]{1,2}, 2);
        System.out.println(map.size());

        System.out.println("ab".substring(1, 10));

    }
}
