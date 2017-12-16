package dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 12/1/17.
 */
public class LongestCommonSubsequence {

    //recursive
    int longestInRecursive(String s1, String s2) {
        return helper(s1, s2, 0, 0);
    }

    int helper(String s1, String s2, int m, int n) {
        if (s1.length() == m || s2.length() == n)
            return 0;

        if (s1.charAt(m) == s2.charAt(n))
            return 1 + helper(s1, s2, m+1, n+1);
        else
            return Math.max(helper(s1, s2, m+1, n), helper(s1, s2, m, n+1));
    }

    //recursive with memorized
    int longestInRecursiveWithMemorized(String s1, String s2) {
        return helper(s1, s2, 0, 0, new HashMap<>());
    }

    int helper(String s1, String s2, int m, int n, Map<String, Integer> map) {
        if (s1.length() == m || s2.length() == n)
            return 0;

        String key = m + "," + n;
        if (map.containsKey(key))
            return map.get(key);

        int len = 0;
        if (s1.charAt(m) == s2.charAt(n)) {
            len = 1 + helper(s1, s2, m+1, n+1, map);
        } else {
            len = Math.max(helper(s1, s2, m+1, n, map), helper(s1, s2, m, n+1, map));
        }
        map.put(key, len);
        return len;
    }

    //dp
    int dynamic(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
//        System.out.println(lcs.longestInRecursive("ABCDGH", "AEDFHR"));

        System.out.println(lcs.dynamic("abcdefghijklmnopqrsjfeiwflsdjfwef", "12345a678b90~!c@#$%d^&*()_+{}"));

//        long s = System.currentTimeMillis();
        System.out.println(lcs.longestInRecursiveWithMemorized("abcdefghijklmnopqrsjfeiwflsdjfwef", "12345a678b90~!c@#$%d^&*()_+{}"));
//        System.out.println(System.currentTimeMillis() - s);

//        System.out.println(lcs.longestInRecursiveWithMemorized("AGGTAB", "GXTXAYB"));
//        s = System.currentTimeMillis();
//        System.out.println(lcs.longestInRecursive("abcdefghijklmnopqrs", "1234567890~!@#$%^&*()_+{}"));
//        System.out.println(System.currentTimeMillis() - s);
    }
}
