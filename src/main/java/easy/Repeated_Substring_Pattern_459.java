package easy;

/**
 * Created by chenlijie on 5/2/17.
 */
public class Repeated_Substring_Pattern_459 {

    public static boolean repeatedSubstringPattern(String s) {

        if (s == null) return false;
        if (s.length() == 1) return true;

        char[] c = s.toCharArray();
        int len = s.length();
        boolean f;
        int i = 1;

        while (i <= len/2) {

            if (len%i != 0) {
                i++;
                continue;
            }
            f = false;

            for (int j = 0; j < len; j += i) {
                for (int k = 0; k < i; k++) {
                    if (c[k] != c[j+k]) {
                        f = true;
                        break;
                    }
                }
                if (f) break;
            }

            if (!f) return true;

            i++;
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(!repeatedSubstringPattern(null));
//        System.out.println(repeatedSubstringPattern("a"));
//        System.out.println(!repeatedSubstringPattern("aba"));
//        System.out.println(repeatedSubstringPattern("aaa"));
//        System.out.println(repeatedSubstringPattern("ababab"));
//        System.out.println(repeatedSubstringPattern("abcabcabc"));
//        System.out.println(!repeatedSubstringPattern("abcadbcabc"));
        System.out.println(repeatedSubstringPattern("abababababababab"));
        System.out.println(repeatedSubstringPattern("123456789123456789"));
    }
}
