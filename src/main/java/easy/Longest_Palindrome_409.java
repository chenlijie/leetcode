package easy;

/**
 * Created by chenlijie on 8/7/17.
 */
public class Longest_Palindrome_409 {

    public static int longestPalindrome(String s) {
        int[] counts = new int['z'-'A'+1];

        for (char c : s.toCharArray()) {
            counts[c-'A']++;
        }

        int num = 0;
        for (int i = 0; i < counts.length; i++) {
            num += counts[i]/2;
        }

        return num*2 < s.length() ? num*2 + 1 : num*2;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));
    }
}
