package microsoft.onsite;

import utility.Utils;

public class WildCardMatching {

    static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

         for (int i = 1; i <= p.length(); i++) {
             dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
         }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j-1) == '*' || p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1));
                dp[i][j] = dp[i][j] || (dp[i][j - 1] && p.charAt(j-1) == '*') || (dp[i - 1][j] && p.charAt(j-1) == '*');
            }
        }

        Utils.printArray(dp);

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        isMatch("adc", "*a*");
    }
}
