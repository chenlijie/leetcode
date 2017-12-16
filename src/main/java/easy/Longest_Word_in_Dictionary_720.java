package easy;

import java.util.Arrays;

/**
 * Created by chenlijie on 12/7/17.
 */
public class Longest_Word_in_Dictionary_720 {

    public String longestWord(String[] words) {

        Arrays.sort(words);
        Trie root = new Trie();

        String res = "";
        int max = 0;

        for (String word : words) {
            if(buildTrie(root, word.toCharArray(), 0)) {
                if (word.length() > max) {
                    max = word.length();
                    res = word;
                }
            }
        }

        return res;
    }

    boolean buildTrie(Trie t, char[] c, int s) {
        if (s >= c.length)
            return false;

        int idx = c[s] - 'a';
        if (t.tries[idx] == null) {
            if (s == c.length-1) {
                t.tries[idx] = new Trie();
                t.tries[idx].isWord = true;
                return true;
            }
            return false;
        } else {
            return buildTrie(t.tries[idx], c, s+1);
        }
    }

    static class Trie {
        Trie[] tries;
        boolean isWord;

        public Trie() {
            tries = new Trie[26];
            isWord = false;
        }
    }

    public static void main(String[] args) {
        Longest_Word_in_Dictionary_720 dic = new Longest_Word_in_Dictionary_720();
        System.out.println(dic.longestWord(new String[]{"rac","rs","ra","rsf","rs","racy","r"}));
    }
}
