package easy;

/**
 * Created by chenlijie on 4/28/17.
 */
public class House_Robber_198 {


    public int rob(int[] nums) {

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
}
