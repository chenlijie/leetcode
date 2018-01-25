package facebook.fblist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class wordDic {
    class TrieNode {
        TrieNode[] next;

        public TrieNode() {
            next = new TrieNode[27];
        }
    }

    private TrieNode root;

    public wordDic() {
        root = new TrieNode();
    }

    int maxLength = 0;

    public void addWord(String word) {
        maxLength = Math.max(word.length(), maxLength);
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new TrieNode();
            cur = cur.next[c - 'a'];
        }
        cur.next[26] = new TrieNode();
    }

    public List<String> searchWord(String word) {
        List<String> res = new LinkedList<>();
        TrieNode cur = root;
        searchHelper(word, 0, cur, res, new StringBuilder());
        return res;
    }

    public void searchHelper(String word, int start, TrieNode cur, List<String> res, StringBuilder sb) {
        if (sb.length() > maxLength) return;
        if (start == word.length()) {
            if (cur.next[26] != null) {
                res.add(sb.toString());
            }
            return;
        }
        char c = word.charAt(start);
        if (c != '*') {
            if (cur.next[c - 'a'] == null) return;
            sb.append(c);
            searchHelper(word, start + 1, cur.next[c - 'a'], res, sb);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        for (char cc = 'a'; cc <= 'z'; cc++) {
            if (cur.next[cc - 'a'] != null) {
                sb.append(cc);
                searchHelper(word, start + 1, cur.next[cc - 'a'], res, sb);
                searchHelper(word, start, cur.next[cc - 'a'], res, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        wordDic search = new wordDic();
        search.addWord("a");
        search.addWord("ab");
        search.addWord("abc");
        search.addWord("abcd");
        search.addWord("abcddabcw");
        search.addWord("axbcddw");

        System.out.println(search.searchWord("a*"));
    }
}