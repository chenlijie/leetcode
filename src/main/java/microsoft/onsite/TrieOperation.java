package microsoft.onsite;

import hard.Word_Search_II_212;

public class TrieOperation {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
    
    static TrieNode root;

    static void build() {
        String[] words = new String[] {"aaa", "abb", "acc"};

        root = new TrieNode();

        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
    }
    
    static boolean delete(String s) {
        return delete(s, 0, root);
    }

    static boolean delete(String s, int i, TrieNode node) {
        if (s.length() == i) {
            node.isWord = false;
            for (TrieNode c : node.children) {
                if (c != null) {
                    return false;
                }
            }
            return true;
        }

        TrieNode child = node.children[s.charAt(i) - 'a'];
        if (child == null)
            return false;

        if (delete(s, i + 1, child) && !child.isWord) {

            node.children[s.charAt(i) - 'a'] = null;

            for (TrieNode n : node.children) {
                if (n != null)
                    return false;
            }

            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        build();
        delete("abb");

        System.out.println();

    }
}
