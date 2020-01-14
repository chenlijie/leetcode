package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlijie on 11/30/17.
 */
public class Word_Break_II_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {

        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> comb = new ArrayList<>();
        comb.add(new ArrayList<>());

        map.put(0, comb);

        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (String w : wordDict) {
                if (i+1-w.length() >= 0 && map.containsKey(i+1-w.length()) && s.substring(i+1-w.length(), i+1).equals(w)) {
                    addWord(i+1-w.length(), i+1, w, map);
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (List<String> list : map.get(len)) {
            res.add(getSentence(list));
        }

        return res;
    }

    void addWord(int i, int j, String w, Map<Integer, List<List<String>>> map) {
        for (List<String> list : map.get(i)) {
            map.putIfAbsent(j, new ArrayList<>());
            List<String> t = new ArrayList<>();
            t.addAll(list);
            t.add(w);
            map.get(j).add(t);
        }
    }

    String getSentence(List<String> temp) {
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < temp.size(); i++) {
            if (i == temp.size() - 1)
                build.append(temp.get(i));
            else {
                build.append(temp.get(i));
                build.append(" ");
            }
        }
        return build.toString();
    }


    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        help(s, wordDict, 0, new StringBuilder(), ans);
        return ans;
    }

    void help(String s, List<String> dict, int idx, StringBuilder words, List<String> ans) {
        if (idx == s.length()) {
            ans.add(words.toString());
            return;
        }

        int len = words.length();

        for (String w : dict) {
            int end = idx + w.length();

            if (end <= s.length()) {
                String sub = s.substring(idx, end);
                if (sub.equals(w)) {

                    if (len == 0) {
                        words.append(sub);
                    } else {
                        words.append(" ").append(sub);
                    }

                    help(s, dict, end, words, ans);
                    words.setLength(len);
                }
            }
        }

    }

    public static void main(String[] args) {
        Word_Break_II_140 w = new Word_Break_II_140();

        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(w.wordBreak2("catsanddog", list));

    }
}
