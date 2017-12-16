package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 8/1/17.
 */
public class Isomorphic_Strings_205 {

    public static boolean isIsomorphic2(String s, String t) {

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

    static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> from = new HashMap<>();
        Map<Character, Character> to = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            Character x = to.get(from.get(c1));
            if (x != null && x != c1) {
                return false;
            }

            char c2 = t.charAt(i);
            Character y = from.get(to.get(c2));

            if (y != null && y != c2) {
                return false;
            }

            if (x == null || y == null) {
                return false;
            }

            from.put(c1, c2);
            to.put(c2, c1);
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
