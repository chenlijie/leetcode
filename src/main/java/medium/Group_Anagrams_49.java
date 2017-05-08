package medium;

import java.util.*;

/**
 * Created by chenlijie on 5/6/17.
 */
public class Group_Anagrams_49 {

    //Counting sort
    public List<List<String>> groupAnagrams2(String[] strs)
    {
        Map<String, List<String>> map = new HashMap<>();
        int[] countingMap = new int[26];

        for (String s : strs)
        {
            String key = SortString(s, countingMap);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public String SortString(String s, int[] map)
    {
        char[] chars = s.toCharArray();
        for (char c : chars)
        {
            map[c - 'a']++;
        }
        int pos = 0;
        for (int i = 0; i < 26; i++)
        {
            while (map[i] > 0)
            {
                chars[pos++] = (char)('a' + i);
                map[i]--;
            }
        }
        return new String(chars);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, Map<String, List<String>>> map = new HashMap<>();

        for (String s : strs) {
            map.putIfAbsent(s.length(), new HashMap<>());

            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);

            map.get(s.length()).putIfAbsent(key, new ArrayList<>());
            map.get(s.length()).get(key).add(s);
        }

        List<List<String>> all = new ArrayList<>();
        map.forEach( (i, v) -> {all.addAll(v.values());});

        return all;
    }

    public static void main(String[] args) {
        List<List<String>> all = new Group_Anagrams_49().groupAnagrams2(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(all.size());
    }
}
