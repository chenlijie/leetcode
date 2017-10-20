package medium;

/**
 * Created by chenlijie on 5/24/17.
 */
public class Maximum_Subarray_53 {

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[i-1]+nums[i]) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i-1] + nums[i];
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }


    public static int maxSubArray3(int[] A) {
        int maxSoFar=A[0], maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
//        System.out.println(new Maximum_Subarray_53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1, 2}));
    }

}
