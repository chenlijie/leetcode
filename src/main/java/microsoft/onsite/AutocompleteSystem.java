package microsoft.onsite;

import java.util.*;

public class AutocompleteSystem {

    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[27];
        }
    }

    TrieNode root;
    TrieNode node;
    StringBuilder sentence;

    Map<String, Integer> counts = new HashMap<>();

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        sentence = new StringBuilder();

        for (int i = 0; i < sentences.length; i++) {

            String s = sentences[i];
            counts.put(s, times[i]);
            insert(s);
        }
    }

    void insert(String sentence) {
        TrieNode node = root;

        for (char c : sentence.toCharArray()) {
            if (c == ' ' && node.children[0] == null) {
                node.children[0] = new TrieNode();
            } else if (c != ' ' && node.children[c - 'a' + 1] == null) {
                node.children[c - 'a' + 1] = new TrieNode();
            }

            if (c == ' ') {
                node = node.children[0];
            } else  {
                node = node.children[c - 'a' + 1];
            }
        }

        node.isEnd = true;
    }

    List<String> input(char c) {
        if (c == '#') {
            String s = sentence.toString();
            sentence.setLength(0);
            counts.put(s, counts.getOrDefault(s, 0) + 1);
            insert(s);
            return new ArrayList<>();
        }

        if (sentence.length() == 0) {
            node = root;
        }

        sentence.append(c);

        Queue<String> q = new PriorityQueue<>((s1, s2) -> {
            int res = counts.get(s1) - counts.get(s2);
            if (res == 0)
                return s2.compareTo(s1);
            return res;
        });

//        int len = sentence.length();

        if (node != null) {
            if (c == ' ') {
                node = node.children[0];
            } else  {
                node = node.children[c - 'a' + 1];
            }
            search(node, sentence, q);
        }

//        sentence.setLength(len);

        List<String> result = new ArrayList<>();

        while (!q.isEmpty()) {
            result.add(0, q.poll());
        }

        System.out.println(result);

        return result;
    }

    private void search(TrieNode node, StringBuilder builder, Queue<String> q) {
        if (node != null) {
            if (node.isEnd) {
                q.offer(builder.toString());
                if (q.size() > 3)
                    q.poll();
            }

            int len = builder.length();
            for (int i = 0; i < 27; i++) {
                if (i == 0) {
                    builder.append(' ');
                } else {
                    builder.append((char)(i + 'a' - 1));
                }
                search(node.children[i], builder, q);
                builder.setLength(len);
            }
        }
    }

    public static void main(String[] args) {

        AutocompleteSystem auto = new AutocompleteSystem(
                new String[]{"i love you", "island","ironman", "i love leetcode"},
                new int[] {5,3,2,2});

        Scanner scanner = new Scanner(System.in);

        while (true) {
            char c = scanner.nextLine().charAt(0);
            auto.input(c);
        }


    }
}
