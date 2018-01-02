package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 12/17/17.
 */
public class AlphabeticalSort {
    //给一个alphabet的order，比如[cdfag]，
    //然后给一个word list，比如[df,ag,cg]，
    //对这个word list做alphabetical sort: [cg, df, ag]。
    //每一个word都只包含alphabet里的字母。Follow up是时空复杂度。

    static class Trie {
        Trie[] tries = new Trie[26];
        boolean isWord;
    }

    public List<String> sort(List<String> words, String order) {
        Trie root = buildTrie(words);
        words.clear();
        visitTrie(root, "", order, words);
        System.out.println(words);
        return words;
    }

    void visitTrie(Trie t, String w, String order, List<String> words) {
        if (t.isWord) {
            words.add(w);
            return;
        }

        for (int j = 0; j < order.length(); j++) {
            char c = order.charAt(j);
            int idx = c - 'a';
            if (t.tries[idx] != null) {
                visitTrie(t.tries[idx], w + c, order, words);
            }
        }
    }

    Trie buildTrie(List<String> words) {
        Trie root = new Trie();
        for (String word : words) {
            buildTrie(0, word, root);
        }
        return root;
    }

    void buildTrie(int i, String w, Trie t) {
        if (i == w.length()) {
            t.isWord = true;
        } else {
            int j = w.charAt(i) - 'a';
            if (t.tries[j] == null) {
                t.tries[j] = new Trie();
            }
            buildTrie(i + 1, w, t.tries[j]);
        }
    }
}
