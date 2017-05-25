package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenlijie on 5/18/17.
 */
public class Word_Break_139 {

    public static boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;
        for (int i=1; i<len+1; i++)
            for (int j=0; j<i; j++)
                if (f[j] && wordDict.contains(s.substring(j,i)))
                {
                    f[i] = true;
                    break;
                }
        return f[len];
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("ab");
        set.add("bc");
        wordBreak("abc", set);
    }
}
