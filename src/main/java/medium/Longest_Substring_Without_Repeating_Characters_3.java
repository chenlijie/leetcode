package medium;

import java.util.*;

/**
 * Created by chenlijie on 4/28/17.
 */
public class Longest_Substring_Without_Repeating_Characters_3 {

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }

        Map<Character, Integer> index = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int left = 0, right = 0;

        for (; right < s.length(); right++) {
            if (index.containsKey(chars[right])) {
                max = Math.max(max, right - left);
                left = index.get(chars[right]) + 1;
            }
            index.put(chars[right], right);
        }

        return Math.max(max, right - left);
    }

    public static int lengthOfLongestSubstring3(String s) {

        if (s == null) {
            return 0;
        }

        int[] visited = new int[256];
        int len = s.length();
        char[] letters = s.toCharArray();

        int max = 0;
        int left = 0;
        int right = 0;

        while (right < len) {

            while (right < len && visited[letters[right]] == 0) {
                visited[letters[right]]++;
                right++;
            }

            max = Math.max(max, right - left);

            while (left < right && right < len && visited[letters[right]] == 1) {
                visited[letters[left]]--;
                left++;
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int right = 0;
        int left = 0;

        for (; right < c.length; right++) {
            if (map.containsKey(c[right])) {
                max = Math.max(right-left, max);
                left = Math.max(left, map.get(c[right]) + 1);
            }

            map.put(c[right], right);
        }
        return Math.max(right-left, max);

    }


    public static void main(String[] args) {

        List list = Arrays.asList(0,1,2,3,4,5,6).subList(2, 6);

//        System.out.println(lengthOfLongestSubstring2("abcabcbb") == 3);
//        System.out.println(lengthOfLongestSubstring2("bbbb") == 1);
//        System.out.println(lengthOfLongestSubstring2("pwwkew") == 3);
//        System.out.println(lengthOfLongestSubstring2("abcabcabcdabc") == 4);
//        System.out.println(lengthOfLongestSubstring2("abcabcabcabcd") == 4);
//        System.out.println(lengthOfLongestSubstring2("dvdf") == 3);
//        System.out.println(lengthOfLongestSubstring2("fdvd") == 3);
        System.out.println(lengthOfLongestSubstring("abba") == 2);
    }
}
