package ebay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWordFromPeriodicTable {

    static class Trie {
        Trie[] children;
        boolean isWord;

        public Trie() {
            children = new Trie[26];
        }
    }

    static int max = 0;
    static String longestWord;

    static String longestWord(List<String> dic, List<String> periodicTable) {
        Trie root = new Trie();

        //build trie
        for (String word : dic) {
            Trie node = root;

            for (char c : word.toLowerCase().toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new Trie();
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        List<String> perodic = new ArrayList<>();
        for (String p : periodicTable) {
            perodic.add(p.toLowerCase());
        }

        //search longest word
        String str = null;
        searchLongWord(root, perodic, new StringBuilder());
        System.out.println(str);
        return longestWord;
    }

    static void searchLongWord(Trie node, List<String> periodic, StringBuilder builder) {

        int len = builder.length();
        for (String p : periodic) {

            Trie child = node.children[p.charAt(0) - 'a'];
            if (p.length() == 2) {
                child = child != null ? child.children[p.charAt(1) - 'a'] : null;
            }

            if (child != null) {
                builder.append(p);

                if (child.isWord && builder.length() > max) {
                    max = builder.length();
                    longestWord = builder.toString();
                }
                searchLongWord(child, periodic, builder);
            }

            builder.setLength(len);
        }
    }

    public static void main(String[] args) {
        List<String> dic = Arrays.asList("lih", "H", "hnazna", "hnana", "mnhhcbnafemgmn", "bbbbcfemg", "mggmlilili");
        List<String> periodicTable = Arrays.asList("H", "Li", "Na", "B", "C", "Fe", "Mg", "Mn");

        longestWord(dic, periodicTable);
        System.out.println(longestWord);
    }
}
