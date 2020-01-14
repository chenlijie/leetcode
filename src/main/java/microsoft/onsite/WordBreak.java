package microsoft.onsite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) return true;

        for (String word : wordDict) {
            if (s.startsWith(word) && wordBreak(s.substring(word.length()), wordDict)) {
                return true;
            }
        }

        return false;
    }

    static boolean wordBreak_2(String s, List<String> wordDict) {

        return wordBreak(0, s, wordDict, new HashMap<>());
    }

    static boolean wordBreak(int i, String s, List<String> wordDict, Map<Integer, Boolean> map) {
        if (i == s.length())
            return true;

        if (map.containsKey(i))
            return map.get(i);

        for (String w : wordDict) {
            if (s.substring(i).startsWith(w) && wordBreak(i + w.length(), s, wordDict, map)) {
                return true;
            } else {
                map.put(i, false);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        wordBreak_2("cars", Arrays.asList("car", "ca", "rs"));
    }
}
