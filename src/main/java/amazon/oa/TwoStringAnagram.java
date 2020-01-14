package amazon.oa;

import java.util.Arrays;
import java.util.Collections;

public class TwoStringAnagram {

    static boolean isAnagram(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;

        int[] counts = new int[256];

        for (char c : s1.toCharArray()) {
            counts[c]++;
        }

        for (char c : s2.toCharArray()) {
            if (counts[c]-- == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("abcdef", "becfad"));
        System.out.println(isAnagram("abcdefa", "becfadb"));

    }
}
