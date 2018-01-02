package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 12/22/17.
 */
public class StringReplace {

    static List<String> replace(String s, String t,String[] r) {
        List<String> ans = new ArrayList<>();
        helper(s, t, r, 0, ans);
        return ans;
    }

    static void helper(String s, String t, String[] rp, int start, List<String> ans) {
        int pre = -1;
        for (int i = start; i <= s.length()-t.length(); i++) {
            int find = s.indexOf(t, i);

            if (find != -1 && (pre == -1 || find != pre)) {
                for (String r : rp) {
                    pre = find;
                    String ns = s.substring(0, find) + r + s.substring(find + r.length());
                    ans.add(ns);
                    helper(ns, t, rp, find + r.length(), ans);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(replace("a#a", "a", new String[]{"B", "C"}).size());
        System.out.println(replace("aaaa", "aa", new String[]{"BB", "CC", "DD"}));
    }
}
