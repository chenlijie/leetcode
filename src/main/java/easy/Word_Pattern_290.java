package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 8/1/17.
 */
public class Word_Pattern_290 {

    public static boolean wordPattern2(String pattern, String str) {

        if (pattern.length() != str.split(" ").length) {
            return false;
        }

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        String[] strs = str.split(" ");

        for (int i = 0; i < strs.length; i++) {
            map1.putIfAbsent(pattern.substring(i, i+1), strs[i]);
            map2.putIfAbsent(strs[i], pattern.substring(i, i+1));

            if (!map1.get(pattern.substring(i, i+1)).equals(strs[i]) || !map2.get(strs[i]).equals(pattern.substring(i, i+1))) {
                return false;
            }
        }

        return true;
    }

    public static  boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "cat cat cat cat"));
    }
}
