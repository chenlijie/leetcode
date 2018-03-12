package tweeter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {

    class Trie {
        Trie[] children = new Trie[26];
        String word;
    }


    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        //build trie from words
        for (String w : words) {
            Trie node = root;
            for (int i = 0; i < w.length(); i++) {
                int idx = w.charAt(i) - 'a';
                if (node.children[idx] == null)
                    node.children[idx] = new Trie();
                node = node.children[idx];
            }
            node.word = w;
        }

        Set<String> ans = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, visited, ans);
            }
        }
        return new ArrayList<>(ans);
    }

    void dfs(char[][] board, int i, int j, Trie node, boolean[][] visited, Set<String> set) {
        if (node == null) return;

        if (node.word != null) {
            set.add(node.word);
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || node.children[board[i][j] - 'a'] == null)
            return;

        if (board[i][j] == 'p') {
            System.out.println('p');
        }

        visited[i][j] = true;
        int[][] dc = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

        for (int[] d : dc) {
            int x = i + d[0];
            int y = j + d[1];

            dfs(board, x, y, node.children[board[i][j] - 'a'], visited, set);
        }

        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'a','b'}, {'a','a'}
//            {'o','a','a','n'},{'e','t','a','e'},{'i','h','k','x'},{'i','f','l','v'}
        };
//        String[] words = new String[] {"oath","pea","eat","rain"};
        String[] words = new String[] {"aaab","aaa"};
        System.out.println(new WordSearch().findWords(board, words));
    }
}
