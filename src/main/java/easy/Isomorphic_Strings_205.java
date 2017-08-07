package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 8/1/17.
 */
public class Isomorphic_Strings_205 {

    public static boolean isIsomorphic(String s, String t) {

        Map<Character, Character> st = new HashMap<>();
        Map<Character, Character> ts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            st.putIfAbsent(s.charAt(i), t.charAt(i));
            ts.putIfAbsent(t.charAt(i), s.charAt(i));

            if (st.get(s.charAt(i)) != t.charAt(i) || ts.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("aa", "ab"));
        System.out.println(isIsomorphic("ab", "aa"));
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }
}
