package microsoft.onsite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    public List<String> findWords(char[][] board, String[] words) {
        //build trie
        TrieNode root = new TrieNode();
        Set<String> dic = new HashSet<>();

        for (String word : words) {
            dic.add(word);

            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        //search word
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(new StringBuilder(), root, board, i, j, new boolean[board.length][board[0].length], dic, ans);
            }
        }

        System.out.println(ans);

        return ans;
    }

    public void search(StringBuilder builder, TrieNode node, char[][] board, int i, int j, boolean[][] visited, Set<String> dic, List<String> ans) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || node.children[board[i][j] - 'a'] == null || dic.isEmpty())
            return;

        int len = builder.length();
        visited[i][j] = true;
        builder.append(board[i][j]);
        node = node.children[board[i][j] - 'a'];

        if (node.isWord) {
            String str = builder.toString();
            if (dic.remove(str))
                ans.add(str);
        }


        int[][] dxy = new int[][] { {0,1}, {1,0}, {-1,0}, {0,-1}};

        for (int[] d : dxy) {
            search(builder, node, board, i + d[0], j + d[1], visited, dic, ans);
            builder.setLength(len);
        }

        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] b = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        WordSearch w = new WordSearch();
        w.findWords(b, new String[] {"oa"});
    }
}
