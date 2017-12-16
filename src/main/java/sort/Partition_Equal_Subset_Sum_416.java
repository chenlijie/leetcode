package sort;

/**
 * Created by chenlijie on 8/27/17.
 */
public class Partition_Equal_Subset_Sum_416 {


    /**
     *
     * dp[i][j] : sum i can be reach or not by first j nums
     * dp[i][j] = dp[i-nums[i]][j-1]
     *
     */
    public static boolean canPartition2(int[] nums) {

        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
        }
        if (target%2 != 0) {
            return false;
        }
        target = target >> 1;

        boolean[] dp = new boolean[target+1];

        dp[0] = true;

        //dp[i][j] = dp[i-nums[j]][j-1] || dp[i][j-1], i >= nums[j]
        for (int j = 1; j <= nums.length; j++) {
//            for (int i = 1; i <= target; i++) {
            for (int i = target; i >= nums[j-1]; i--) {
                dp[i] = dp[i-nums[j-1]] || dp[i];
            }
        }

        return dp[target];
    }

    public static boolean canPartition(int[] nums) {

        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
        }
        if (target%2 != 0) {
            return false;
        }
        target = target >> 1;

        boolean[][] dp = new boolean[target+1][nums.length+1];

        for (int i = 0; i <= nums.length; i++) {
            dp[0][i] = true;
        }

        //dp[i][j] = dp[i-nums[j]][j-1] || dp[i][j-1], i >= nums[j]

        for (int j = 1; j <= nums.length; j++) {
            for (int i = 1; i <= target; i++) {
                if (i >= nums[j-1]) {
                    dp[i][j] = dp[i-nums[j-1]][j-1]|| dp[i][j-1];
                }
//                dp[i][j] = dp[i][j] || dp[i][j-1];
            }
        }

        return dp[target][nums.length-1];
    }


    public static void main(String[] args) {

//        System.out.println(canPartition(new int[]{66,90,7,6,32,16,2,78,69,88,85,26,3,9,58,65,30,96,11,31,99,49,63,83,79,97,20,64,81,80,25,69,9,75,23,70,26,71,25,54,1,40,41,82,32,10,26,33,50,71,5,91,59,96,9,15,46,70,26,32,49,35,80,21,34,95,51,66,17,71,28,88,46,21,31,71,42,2,98,96,40,65,92,43,68,14,98,38,13,77,14,13,60,79,52,46,9,13,25,8}));
//        System.out.println(!canPartition(new int[]{1, 1, 2, 5, 5, 5, 5, 1}));
//        System.out.println(canPartition(new int[]{1, 1, 1, 1}));
        System.out.println(canPartition2(new int[]{2, 1, 4, 5}));
//        System.out.println(!canPartition(new int[]{2, 2, 3, 5}));
    }
}
