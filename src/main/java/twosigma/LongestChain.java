package twosigma;

import java.util.*;

public class LongestChain {
//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=135529&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D34%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

    /*
    Problem Statement
You are given a library with n words (w[0], w[1], ...,w[n-1]). You choose a word from it, and in each step, remove one letter from this word only if doing so yields another word in the library. What is the longest possible chain of these removal steps?

Constraints:.鏈枃鍘熷垱鑷�1point3acres璁哄潧
1 <= n <= 50000
1 <= the length of each string in w <= 50
Each string is composed of lowercase ascii letters only
The function should take in an array of strings w as its argument and should return a single integer representing the length of the longest chain of character removals possible.. 鍥磋鎴戜滑@1point 3 acres

Example input/output. Waral 鍗氬鏈夋洿澶氭枃绔�,
a
b
ba
bca
bda
bdca

     */

    int longestChain(List<String> words) {

        Map<String, Integer> dc = new HashMap<>();
        for (String w : words) {
            dc.put(w, -1);
        }

        int max = 0;
        for (String w : words) {
            if (w.length() > max) {
                max = Math.max(max, search(w, dc));
            }
        }

        System.out.println("Longest chain length is " + max);

        return max;
    }

    public int search(String w, Map<String, Integer> dc) {
        if (dc.getOrDefault(w, -1) != -1)
            return dc.get(w);

        int max = 1;
        for (int i = 0; i < w.length(); i++) {
            String s = w.substring(0, i) + w.substring(i + 1, w.length());

            if (dc.containsKey(s)) {
                max = Math.max(max, 1 + search(s, dc));
            }
        }
        dc.put(w, max);

        return max;
    }

    public static void main(String[] args) {
        LongestChain c = new LongestChain();
        c.longestChain(Arrays.asList("abcd", "abc", "bc", "c", "abcde", "abcdef"));

        System.out.println("aa".matches(".+"));
    }
}
