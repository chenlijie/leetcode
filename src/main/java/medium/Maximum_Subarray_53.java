package medium;

/**
 * Created by chenlijie on 5/24/17.
 */
public class Maximum_Subarray_53 {

    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int idx = 0;

        for (int i = 1; i < nums.length; i++) {
            if (max < 0) {
                if (nums[i] > max) {
                    idx = i;
                    max = nums[i];
                }
            } else {
                if (nums[i] < 0) {
                    continue;
                }
                int s = sum(idx+1, i, nums);
                if (s < 0) {
                    continue;
                }
                if (s+max > nums[i]) {
                    max = s + max;
                    idx = i;
                } else {
                    max = nums[i];
                    idx = i;
                }
            }
        }
        return max;
    }

    private int sum(int i, int j, int[] nums) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            s += nums[k];
        }
        return s;
    }

    public int maxSubArray2(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
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
        System.out.println(new Maximum_Subarray_53().maxSubArray3(new int[]{8,-19,5,-4,20}));
    }

}
