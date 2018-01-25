package hard;

public class Regular_Expression_Matching_10 {

    static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        int m = p.length();
        int n = s.length();

        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= m; i++) {
            if (i == 1) {
                dp[i][0] = p.charAt(i-1) == '*';
            } else {
                dp[i][0] = p.charAt(i-1) == '*' && dp[i-2][0];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(i - 1) == '*') {
                    if (dp[i - 2][j] || ((p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.') && dp[i][j-1])) {
                        dp[i][j] = true;
                    }
                } else {
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '.');
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", ".*"));
    }
}
