package microsoft.onsite;

import utility.Utils;

public class RegularExpressionMatch {

    static boolean isMatch_2(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            if (i == 1) {
                dp[0][i] = p.charAt(i - 1) == '*';
            } else {
                dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.');
                    dp[i][j] = dp[i][j] || dp[i][j - 2];
                }
            }
        }

        Utils.printArray(dp);
        return dp[s.length()][p.length()];
    }

    static boolean isMatch(String s, String p) {
        if (p.isEmpty())    return s.isEmpty();

        if ('*' == p.charAt(1))
            // x* matches empty string or at least one character: x* -> xx*
            // *s is to ensure s is non-empty
            return (isMatch(s, p.substring(2)) || !s.isEmpty() && (s.charAt(0) == p.charAt(0) || '.' == p.charAt(0)) && isMatch(s.substring(1), p));
        else
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || '.' == p.charAt(0)) && isMatch(s.substring(1), p.substring(1));
    }


    public static void main(String[] args) {
        System.out.println(isMatch("abcd", "ab*cd"));
    }
}
