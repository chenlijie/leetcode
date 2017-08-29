package medium;

/**
 * Created by chenlijie on 8/23/17.
 */
public class Is_Subsequence_392 {


    public static boolean isSubsequence(String s, String t) {

        int i = 0, j = 0;

        for (; i < s.length() & j < t.length() ;) {
            if (s.charAt(i) != t.charAt(j)) {
                j++;
            } else {
                i++;
                j++;
            }
        }

        return i == s.length();
    }

    public static void main(String[] args) {
//        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("b", "c"));
    }
}
