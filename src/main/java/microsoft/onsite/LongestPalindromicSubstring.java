package microsoft.onsite;

public class LongestPalindromicSubstring {

    static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        int max = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int w = extend(s, i, i);
            if (2 * w - 1 > max) {
                start = i - w + 1;
                end = i + w;
                max = end - start;
            }
            w = extend(s, i, i + 1);
            if (2 * w > max) {
                start = i - w + 1;
                end = i + 1 + w;
                max = end - start;
            }
        }

        return s.substring(start, end);
    }

    static int extend(String s, int i, int j) {
        int w = 0;
        while (i >= 0 && j < s.length() && s.charAt(i--) == s.charAt(j++))
            w++;

        return w;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }
}
