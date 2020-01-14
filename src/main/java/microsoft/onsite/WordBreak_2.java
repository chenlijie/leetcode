package microsoft.onsite;

import java.util.*;

public class WordBreak_2 {


    public static  List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<>());
    }

    static List<String> helper(String s, List<String> dict, Map<String, List<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        if ("".equals(s)) {
            List<String> list = new ArrayList<>();
            list.add("\b");
            return list;
        }

        List<String> r = new ArrayList<>();

        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> list = helper(s.substring(word.length()), dict, map);

                for (int i = 0; i < list.size(); i++) {
                    if ("".equals(list.get(i)))
                        r.add(word);
                    else
                        r.add(word + " " + list.get(i));
                }

            }
        }

        map.put(s, r);

        return r;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> list = Arrays.asList("cat","cats","and","sand","dog");
        System.out.println(wordBreak(s, list));

    }
}
