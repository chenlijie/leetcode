package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenlijie on 7/31/17.
 */
public class Word_Search_II_212 {

    static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    int[][] dirct = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    TrieNode buildDict(String[] words) {
        TrieNode root = new TrieNode();

        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }

    void backTracking(char[][] board, int i, int j, int m, int n, TrieNode node, String builder, Set<String> ans) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#') return;

        int idx = board[i][j] - 'a';
        if (node.children[idx] == null) return;

        char c = board[i][j];
        if (node.children[idx] != null && node.children[idx].isWord) {
            ans.add(builder + c);
        }

        board[i][j] = '#';
        for (int[] d : dirct) {
            backTracking(board, i + d[0], j + d[1], m, n, node.children[idx], builder + c, ans);
        }
        board[i][j] = c;
    }


    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildDict(words);

        int m = board.length;
        int n = board[0].length;

        Set<String> ans = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backTracking(board, i, j, m, n, root, "", ans);
            }
        }

        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'a','a'},{'a','b'}
        };
        
        String[] strs = new String[]{"aaab","aaa"};
        Word_Search_II_212 search = new Word_Search_II_212();
        System.out.println(search.findWords(board, strs));

    }
}
