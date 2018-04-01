package twosigma;

import medium.Trie;

import java.util.*;

public class LongestChain {
//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=135529&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D34%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=201096&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D34%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
    /**
        Problem Statement
        You are given a library with n words (w[0], w[1], ...,w[n-1]).
        You choose a word from it, and in each step, remove one letter from
        this word only if doing so yields another word in the library.
        What is the longest possible chain of these removal steps?

        Constraints:
        1 <= n <= 50000
        1 <= the length of each string in w <= 50
        Each string is composed of lowercase ascii letters only
        The function should take in an array of strings w as its argument
        and should return a single integer representing the length of the
        longest chain of character removals possible.

        Example input/output.
        a
        b
        ba
        bca
        bda
        bdca

     **/

    class Trie {
        Trie[] children;
        boolean isWord;

        public Trie() {
            this.children = new Trie[26];
        }
    }

    int longestChain2(List<String> words) {

        //build trie
        Trie root = new Trie();
        for (String word : words) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new Trie();
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        return searchLongChain(root);
    }

    int searchLongChain(Trie node) {
        int max = 1;
        for (Trie child : node.children) {
//            if (child != null && child.)
        }
        return max;
    }

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
        Collections.addAll(new HashSet<>(), new String[]{"", ""});
    }
}
