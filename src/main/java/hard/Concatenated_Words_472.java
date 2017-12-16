package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlijie on 12/7/17.
 */
public class Concatenated_Words_472 {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words.length <= 1)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (!"".equals(word) && helper(word, words, 0, new HashMap<>()))
                res.add(word);
        }
        return res;
    }

    boolean helper(String word, String[] words, int d, Map<String, Boolean> map) {
        if ("".equals(word)) {
            return d > 1;
        }

        for (String w : words) {
            if (word.startsWith(w) && helper(word.substring(w.length()), words, d+1, map)) {
                map.put(word, true);
                return true;
            }
        }
        map.put(word, false);
        return false;
    }

    public static void main(String[] args) {
        Concatenated_Words_472 c = new Concatenated_Words_472();
        System.out.println(c.findAllConcatenatedWordsInADict(new String[] {"","rfkqyuqfjkx","vnrtysfrzrmzl","gfve","qfpd","lqdqrrcrwdnxeuo","wyvfpjyglzrmhfqp","ubheeqt","rmbxlcmn","taqakgim","apsbu","khwnykughmwrlk"}));
    }
}
