package medium;

/**
 * Created by chenlijie on 5/24/17.
 */
public class Gas_Station_134 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int min = Integer.MAX_VALUE;
        int sum = 0;
        int index = -1;

        for (int i = 0; i < gas.length; i++) {
            sum = sum + gas[i] - cost[i];
            if (sum < min) {
                index = i;
                min = sum;
            }
        }

        if (sum < 0) {
            return -1;
        } else {
            return (index+1)%gas.length;
        }
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(canCompleteCircuit(new int[]{2,3,1}, new int[]{3,2,1}));
    }
}
