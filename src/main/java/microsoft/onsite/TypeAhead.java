package microsoft.onsite;

import java.util.*;

public class TypeAhead {


    //autocomplete LZ说了半天 三哥又说是让写算法 LZ ： #￥……%%……#@  前缀树 轻松解决 扩展 如何使用相似数据结构实现纠错 例如 test 写成了tets 如何实现
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    static TrieNode root = new TrieNode();

    static void build(String[] words) {

        for (String word : words) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }

            node.isWord = true;
        }
    }

    static void search(String s) {
        List<String> similar = new ArrayList<>();

        TrieNode node = root;
        for (char c : s.toCharArray()) {
            node = node.children[c - 'a'];
            if (node == null) {
                System.out.println("[]");
                return;
            }
        }

        search(node, new StringBuilder(s), similar);
        System.out.println(similar);
    }

    static void search(TrieNode node, StringBuilder builder, List<String> similar) {
        if (node != null) {
            if (node.isWord)
                similar.add(builder.toString());

            int len = builder.length();
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    builder.append((char)(i + 'a'));
                    search(node.children[i], builder, similar);
                    builder.setLength(len);
                }
            }
        }
    }

    public static void main(String[] args) {
        build(new String[]{"ab", "apple", "banana", "china", "orange", "application", "apps", "big", "brother", "biggest"});


        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            String line = s.nextLine();
            if ("exit".equals(line))
                break;
            search(line);
        }
    }
}
