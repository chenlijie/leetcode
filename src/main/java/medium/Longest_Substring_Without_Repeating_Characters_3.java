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
        System.out.println(lengthOfLongestSubstring4("dvdf") == 3);
    }

    public static int lengthOfLongestSubstring4(String s) {
        if (s == null) return 0;

        int max = 0;
        boolean[] used = new boolean[256];

        for (int i = 0, j = 0; i < s.length() && j < s.length(); i++) {

            while (j < s.length() && !used[s.charAt(j)]) {
                used[s.charAt(j++)] = true;
            }

            max = Math.max(j - i, max);

            while (j < s.length() && i < j && s.charAt(i) != s.charAt(j)) {
                used[s.charAt(i++)] = false;
            }
            j++;
        }

        return max;
    }
}
