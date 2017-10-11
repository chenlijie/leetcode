package medium;


public class Longest_Palindromic_Substring_5 {

    public static String longestPalindrome(String s) {

        if (s == null) {
            return null;
        }

        int len = s.length();
        int start = 0;
        int end = 0;
        int max = 0;

        for (int i = 0; i < len; i++) {

            int[] res = longest(i, i, s, len-1);

            if (res[1] - res[0] + 1 > max) {
                max = res[1] - res[0] + 1;
                start = res[0];
                end = res[1];
            }

            if (i < len-1 && s.charAt(i) == s.charAt(i + 1)) {
                res = longest(i, i + 1, s, len-1);

                if (res[1] - res[0] + 1 > max) {
                    max = res[1] - res[0] + 1;
                    start = res[0];
                    end = res[1];
                }
            }
        }

        return s.substring(start, end+1);
    }

    private static int[] longest(int i, int j, String s, int end) {

        while (i > 0 && j < end && s.charAt(i-1) == s.charAt(j+1)) {
            i--;
            j++;
        }

        return new int[] {i, j};
    }

    public static void main(String[] args) {
        //ababa b -> babab
        //cbabc b -> bcb
        System.out.println(longestPalindrome("abccb"));
        System.out.println(longestPalindrome("ababababababab"));
//        System.out.println(longestPalindrome("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"));
//        System.out.println(longestPalindrome("aabaaa"));
//        System.out.println(longestPalindrome("bananas"));
//        System.out.println(longestPalindrome("abadd"));
//        System.out.println(longestPalindrome("abaa"));
//        System.out.println(longestPalindrome("aa"));
//        System.out.println(longestPalindrome("abbc"));
//        System.out.println(longestPalindrome("abbac"));
//        System.out.println(longestPalindrome("aba1734abcddcba123"));
    }

}
