package medium;

import java.util.*;

/**
 * Created by chenlijie on 4/28/17.
 */
public class Longest_Substring_Without_Repeating_Characters_3 {

    public static int lengthOfLongestSubstring(String s) {

        char[] c = s.toCharArray();
        List<Character> list = new ArrayList<Character>();
        int max = 0;

        for (int i = 0; i < c.length; i++) {
            if (list.contains(c[i])) {
                max = max < list.size() ? list.size() : max;
                list = list.subList(list.indexOf(c[i])+1, list.size());
                list.add(c[i]);
            } else {
                list.add(c[i]);
            }
        }
        max = max < list.size() ? list.size() : max;
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int i = 0;
        int j = 0;

        for (; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                max = Math.max(i-j, max);
                j = Math.max(j, map.get(c[i]) + 1);
            }

            map.put(c[i], i);
        }
        return Math.max(i-j, max);

    }


    public static void main(String[] args) {

        List list = Arrays.asList(0,1,2,3,4,5,6).subList(2, 6);

        System.out.println(lengthOfLongestSubstring2("abcabcbb") == 3);
        System.out.println(lengthOfLongestSubstring2("bbbbb") == 1);
        System.out.println(lengthOfLongestSubstring2("pwwkew") == 3);
        System.out.println(lengthOfLongestSubstring2("abcabcabcdabc") == 4);
        System.out.println(lengthOfLongestSubstring2("abcabcabcabcd") == 4);
        System.out.println(lengthOfLongestSubstring2("dvdf") == 3);
        System.out.println(lengthOfLongestSubstring2("fdvd") == 3);
        System.out.println(lengthOfLongestSubstring2("abba") == 2);
    }
}
