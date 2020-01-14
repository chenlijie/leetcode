package amazon.oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordBreakList {

    public List<String> solution(List<String> words) {
        Collections.sort(words, Comparator.comparing(String::length));

        List<String> ans = new ArrayList<>();
        int len = words.size();
        for (int i = len - 1; i > 0; i--) {
            if (wordBreak(words.get(i), words, i)) {
                ans.add(words.get(i));
            }
        }

        System.out.println(ans);
        return ans;
    }

    public boolean wordBreak(String s, List<String> wordDict, int end) {
        if (s == null || wordDict == null) return false;

        boolean[] dp = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || dp[i - 1]) {
                for (int j = 0; j < end; j++) {
                    String w = wordDict.get(j);
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
        WordBreakList w = new WordBreakList();
        List<String> list = new ArrayList<>();
        list.add("de");
        list.add("leetcode");
        list.add("co");
        list.add("code");
        list.add("leet");
        list.add("le");
        list.add("etcode");
        list.add("leetco");
        list.add("eetcode");
        list.add("leetcod");
        list.add("et");
        w.solution(list);
    }
}

