package easy;

/**
 * Created by chenlijie on 11/14/17.
 */
public class Valid_Palindrome_II_680 {

    static boolean validPalindrome(String s) {

        return helper(s, 0, s.length() - 1, 0);
    }

    static boolean helper(String s, int i, int j, int change) {
        if (change > 1) {
            return false;
        }

        if (i >= j) {
            return true;
        }

        if (i + 1 == j) {
            return change == 0 || s.charAt(i) == s.charAt(j);
        }

        if (s.charAt(i) == s.charAt(j)) {
            return helper(s, i+1, j-1, change);
        } else {
            return helper(s, i+1, j, change) || helper(s, i, j-1, change);
        }
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }
}
