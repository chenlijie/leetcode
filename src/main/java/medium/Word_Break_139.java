package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenlijie on 5/18/17.
 */
public class Word_Break_139 {

    //leetcode
    //le etco leet code
    public boolean wordBreak(String s, List<String> wordDict) {

        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {

                if (wordBreak(s.substring(i+1), wordDict)) {
                    return true;
                }
            }
        }

        return "".equals(s);
    }

    public boolean wordBreak2(String s, List<String> wordDict) {

        boolean[] f = new boolean[s.length()+1];
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public static void main(String[] args) {
        List<String> set = new ArrayList<>();
        set.add("le");
        set.add("etco");
        set.add("leet");
        set.add("code");

        System.out.println(new Word_Break_139().wordBreak2("leetcode", set));

    }
}
