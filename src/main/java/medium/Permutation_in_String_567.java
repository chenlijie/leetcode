package medium;

/**
 * Created by chenlijie on 8/18/17.
 */
public class Permutation_in_String_567 {

    static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length())
            return false;

        int len1 = s1.length();
        int len2 = s2.length();

        char[] map = new char[256];
        for (int i = 0; i < len1; i++) {
            map[s1.charAt(i)]++;
        }

        int count = len1;

        for (int j = 0, i = 0; i < len2; i++) {
            char c = s2.charAt(i);

            if (map[c]-- > 0) {
                count--;

                while (count == 0) {
                    if (len1 == i - j + 1) {
                        return true;
                    }
                    if (++map[s2.charAt(j++)] > 0) {
                        count++;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
