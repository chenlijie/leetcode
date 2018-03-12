package twosigma;

public class WildCard {

//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=305953&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D34%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
    //wildcard变形 +可以match 1-multiple characters  #可以match 0-9

    static boolean isMatch(String s, String p) {
        if (s == null && p == null)
            return true;

        if (s == null || p == null)
            return false;

        boolean isMatch = isMatch(s.toCharArray(), 0, p.toCharArray(), 0);

        System.out.println(String.join(" ", s, "and", p, isMatch ? "are match." : "aren't match"));

        return isMatch;
    }

    static boolean isMatch(char[] s, int i, char[] p, int j) {
        if (s.length == i && p.length == j)
            return true;

        if (s.length == i || p.length == j)
            return false;

        if (p[j] == '+') {
            for (int k = i + 1; k <= s.length; k++) {
                if (isMatch(s, k, p, j + 1))
                    return true;
            }
        } else if (p[j] == '#') {
            return  Character.isDigit(s[i]) && isMatch(s, i + 1, p, j + 1);
        } else {
            return s[i] == p[j] && isMatch(s, i + 1, p, j + 1);
        }

        return false;
    }

    static boolean isMatch2(String s, String p) {
        if (s == null && p == null)
            return true;

        if (s == null || p == null)
            return false;

        int m = s.length();
        int n = p.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= m; i++) {

//            for (int j = 1; j <= n; j++) {
            for (int j = n; j >= 1; j--) {
                char c1 = s.charAt(i - 1);
                char c2 = p.charAt(j - 1);
                dp[j] = (c2 == '+' && (dp[j] || dp[j-1])) || ((c1 == c2 || Character.isDigit(c1) && c2 == '#') && dp[j - 1]);
            }
        }

        System.out.println(String.join(" ", s, "and", p, dp[n] ? "are match." : "aren't match"));
        return dp[n];
    }

    public static void main(String[] args) {

        isMatch(null, null);
        isMatch2(null, null);

        isMatch("", "");
        isMatch2("", "");

        isMatch("a", null);
        isMatch2("a", null);

        isMatch(null, "a");
        isMatch2(null, "a");

        isMatch("abc", "abc");
        isMatch2("abc", "abc");

        isMatch("a1c", "a#c");
        isMatch2("a1c", "a#c");

        isMatch("a12c", "a#c");
        isMatch2("a12c", "a#c");

        isMatch("ac", "a+c");
        isMatch2("ac", "a+c");

        isMatch("abc", "a+c");
        isMatch2("abc", "a+c");

        isMatch("ab3b1bc", "a+c");
        isMatch2("ab3b1bc", "a+c");

        isMatch("abcd1234", "a+c+2#4");
        isMatch2("abcd1234", "a+c+2#4");

        isMatch("aaaaaaaaaaa", "+aaaaaaaaaad");
        isMatch2("aaaaaaaaaaa", "+aaaaaaaaaad");
    }
}
