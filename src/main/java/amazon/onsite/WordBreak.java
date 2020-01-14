package amazon.onsite;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class WordBreak {


    static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) return false;

        boolean[] dp = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || dp[i - 1]) {
                for (String w : wordDict) {
                    if (s.substring(i).startsWith(w)) {
                        dp[i + w.length() - 1] = true;

                        if (dp[s.length() - 1])
                            return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        wordBreak("aaaaaa", Arrays.asList("aa", "aaaa"));

        System.out.println(Runtime.getRuntime().totalMemory());

//        int[] b = new int[200000000];

        System.out.println(0x10);
    }
}
