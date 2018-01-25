package facebook.fblist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WildCardSearch {

    private static class Trie {
        Trie[] children;
        boolean isWord;

        public Trie() {
            this.children = new Trie[26];
            this.isWord = false;
        }
    }

    Trie root = new Trie();
    char[] map = new char[26];

    public WildCardSearch() {
        for (char c = 'a'; c <= 'z'; c++) {
            map[c - 'a'] = c;
        }
    }

    void addWord(List<String> words) {

        for (String word : words) {
            Trie node = root;

            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }

            node.isWord = true;
        }
    }

    List<String> search(String pattern) {
        List<String> ans = new ArrayList<>();

        search(root, pattern, 0, new StringBuilder(), ans);
        return ans;
    }

    void search(Trie node, String pattern, int idx, StringBuilder word, List<String> ans) {
        if (idx == pattern.length() || (idx + 1 == pattern.length() && pattern.charAt(idx) == '*')) {
            if (node.isWord) {
                ans.add(word.toString());
            }
            return;
        }


        if (pattern.charAt(idx) == '*') {
            for (int i = 0; i < 26; i++) {

                if (node.children[i] != null) {
                    int len = word.length();
                    word.append(map[i]);

                    //do wild match
                    search(node.children[i], pattern, idx, word, ans);
                    //stop wild card
                    search(node.children[i], pattern, idx + 1, word, ans);

                    word.setLength(len);
                }
            }
        } else {
            int i = pattern.charAt(idx) - 'a';
            if (node.children[i] != null) {
                int len = word.length();
                word.append(map[i]);
                search(node.children[i], pattern, idx + 1, word, ans);
                word.setLength(len);
            }
        }
    }

    public static void main(String[] args) {
//        List<String> words = new ArrayList<>();
//        words.add("a");
//        words.add("ab");
//        words.add("abc");
//        words.add("abcd");
//        words.add("abcddabcw");
//        words.add("axbcddw");
//
//
//        WildCardSearch search = new WildCardSearch();
//        search.addWord(words);
//
//        System.out.println(search.search("a"));

        StringBuilder builder = new StringBuilder();
        builder.append("12345");
        builder.setLength(1);
        System.out.println(builder.toString());
    }
}
