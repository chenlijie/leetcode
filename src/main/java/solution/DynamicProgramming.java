package solution;

/**
 * Created by chenlijie on 4/28/17.
 */
public class DynamicProgramming {

    int getMinSteps (int n, int[] memo ) {
        if ( n == 1 )  return 0;  // base case
        if( memo[n] != -1 ) {
            return memo[n];  // we have solved it already :)
        }
        int r = 1 + getMinSteps( n - 1, memo );  // '-1' step .  'r' will contain the optimal answer finally
        if( n%2 == 0 )   r  =  r < 1 + getMinSteps( n / 2, memo ) ? r : 1 + getMinSteps( n / 2, memo );  //  '/2' step
        if( n%3 == 0 )   r  =  r < 1 + getMinSteps( n / 3, memo ) ? r : 1 + getMinSteps( n / 3, memo );  //  '/3' step
        memo[n] = r ;  // save the result. If you forget this step, then its same as plain recursion.
        return r;
    }

    /**
     *  F(n) =   1 + min{  F(n-1) ,  F(n/2)  ,  F(n/3)  }
     *  1 (0)
     *  2 (1)
     *  3 (1)
     *  4 = 1 + min{  F(4-1) ,  F(4/2)  ,  F(4/3)  } = 1 + 1 = 2
     *  5 = 1 + min{  F(4-1) ,  F(4/2)  ,  F(4/3)  } = 1 + f(3) = 1 + 1 = 2
     *  6 = 1 + min{  F(6-1) ,  F(6/2)  ,  F(6/3)  } = 1 + f(3) = 1 + 1 = 2
     *
     */

    int getMinSteps (int n) {

        if (n == 1) return 0;

        int[] dp = new int[n+1];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = 1 + dp[i-1];
            if (i%2 == 0) dp[i] = dp[i] < 1 + dp[i/2] ? dp[i] : 1 + dp[i/2];
            if (i%3 == 0) dp[i] = dp[i] < 1 + dp[i/3] ? dp[i] : 1 + dp[i/3];
        }

        return dp[n];
    }

    /**
     * Longest Increasing subsequence
     * S= {a1 , a2 , a3, a4, ............., an-1, an }
     *
     * f(n) = f(n-1) + 1 if an-1 < an, else f(n) = 1
     *
     */

    public static int findLongestIncreasingSubsequence(int[] a) {
        int[] dp = new int[a.length];
        dp[0] = 1;
        int max = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
            max = max > dp[i] ? max : dp[i];
        }

        return max;
    }

    public static void main(String[] args) {
        int [] memo = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        System.out.println(new DynamicProgramming().getMinSteps(10));

        System.out.println(DynamicProgramming.findLongestIncreasingSubsequence(new int[]{1,2,3,4,5,6,1}));
        System.out.println(DynamicProgramming.findLongestIncreasingSubsequence(new int[]{1,2,1,3,4,1,5,1,6,1}));
        System.out.println(DynamicProgramming.findLongestIncreasingSubsequence(new int[]{1,2,1,3,1,4,1,5,1,4,8,19,6,1}));
    }

}
