package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Longest_Palindromic_Substring_5 {

    public static String longestPalindrome(String s) {

        if (s == null) {
            return null;
        }

        String max = s.substring(0, 1);
        int start = 0;

        for (int i = 1; i < s.length(); i++) {
            if ((start-1) >= 0 && s.charAt(i) == s.charAt(start-1)) {
                max = (i - start + 1) >= max.length() ? s.substring(start-1, i+1) : max;
                start--;
            } else if (containsSame(start, i, s.charAt(i), s)) {
                max = (i - start + 1) >= max.length() ? s.substring(start, i+1) : max;
            } else if ((i-2) >= 0 && s.charAt(i) == s.charAt(i-2)) {
                max = 3 > max.length() ? s.substring(i-2, i+1) : max;
                start = i-2;
            } else if ((i-1) >= 0 && s.charAt(i) == s.charAt(i-1)) {
                max = 2 > max.length() ? s.substring(i-1, i+1) : max;
                start = i-1;
            } else {
                start = i;
            }
        }

        return max;
    }

    private static boolean containsSame(int from, int to, char c, String s) {
        for (int i = from; i < to; i++) {
            if (s.charAt(i) != c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //ababa b -> babab
        //cbabc b -> bcb
        System.out.println(longestPalindrome("ababab"));
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
