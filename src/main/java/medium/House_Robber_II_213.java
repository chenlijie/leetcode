package medium;

/**
 * Created by chenlijie on 4/29/17.
 */
public class House_Robber_II_213 {

    /**
     *  1, 2, 3 ... n-1, n
     *
     *  scenario 1 : rob 1 and not rob n -> not rob 2, either rob or not rob 3, either rob n-1 and not rob n-1
     *  scenario 2 : not rob 1 and rob n -> either rob or not rob 2, either rob n-2 and not rob n-2, not rob n-1
     *  scenario 3 : not rob 1 and not rob n -> either rob or not rob 2, either rob n-1 and not rob n-1
     *
     *  find max from scenario 1, 2, 3
     *
     */

    public static int rob(int[] nums) {

        if (nums.length == 0) return 0;

        int rob = 0;
        int notRob = 0;
        int current;

        for (int i = 2; i < nums.length-1; i++) {
            current = notRob + nums[i];
            notRob = Math.max(rob, notRob);
            rob = current;
        }

        int max = Math.max(rob, notRob) + nums[0];

        rob = 0;
        notRob = 0;
        for (int i = 1; i < nums.length-2; i++) {
            current = notRob + nums[i];
            notRob = Math.max(rob, notRob);
            rob = current;
        }

        max = Math.max(max, Math.max(rob, notRob) + nums[nums.length-1]);

        rob = 0;
        notRob = 0;
        for (int i = 1; i < nums.length-1; i++) {
            current = notRob + nums[i];
            notRob = Math.max(rob, notRob);
            rob = current;
        }
        return Math.max(max, Math.max(rob, notRob));
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{}) == 0);
//        System.out.println(rob(new int[]{1,10,1,10,1}) == 20);
        System.out.println(rob(new int[]{10,1,1,20,1,1}) == 30);
        System.out.println(rob(new int[]{1,1,10,1,1,10}) == 20);
    }
}
