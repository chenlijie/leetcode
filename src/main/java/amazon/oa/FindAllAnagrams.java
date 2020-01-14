package amazon.oa;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

    static List<Integer> findAnagrams(String s, String p) {

        if (s == null || p == null)
            return new ArrayList<>();

        int[] occurs = new int[256];
        for (char c : p.toCharArray())
            occurs[c]++;

        int count = p.length();

        List<Integer> ans = new ArrayList<>();

        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (occurs[c]-- > 0) {
                count--;
            }

            while (count == 0) {
                if (i - j + 1 == p.length()) {
                    ans.add(j);
                }

                if (++occurs[s.charAt(j++)] > 0) {
                    count++;
                }
            }
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        findAnagrams("acbacabaab", "ab");
    }
}
