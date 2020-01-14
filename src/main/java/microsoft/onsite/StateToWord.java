package microsoft.onsite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StateToWord {

    static class Trie {
        Trie[] children = new Trie[26];
        String word;
        boolean isWord;
    }

    private static class State {
        String name;
        List<State> adj = new ArrayList<>();

        public State(String name) {
            this.name = name;
        }
    }

    static String ans = "";

    static String longestWord(State[] states, String[] dict) {

        Trie root = new Trie();
        for (String word : dict) {
            Trie node = root;

            for (char c : word.toLowerCase().toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new Trie();
                node = node.children[c - 'a'];
            }

            node.isWord = true;
            node.word = word;
        }

        Set<State> visited = new HashSet<>();

        for (State state : states) {
            findLongestWord(state, visited, root);
        }

        System.out.println(ans);
        return ans;
    }

    static void findLongestWord(State state, Set<State> visited, Trie node) {
        if (!visited.contains(state)) {
            String name = state.name.toLowerCase();
            for (int i = 0; i < name.length() && node != null; i++) {
                char c = name.charAt(i);
                node = node.children[c - 'a'];
                if (node != null) {
                    if (node.isWord) {
                        if (node.word.length() > ans.length()) {
                            ans = node.word;
                        }
                    }
                    visited.add(state);

                    for (State s : state.adj) {
                        findLongestWord(s, visited, node);
                    }

                    visited.remove(state);
                }
            }
        }
    }

    public static void main(String[] args) {
        State s1 = new State("Texas");
        State s2 = new State("California");
        State s3 = new State("Oklahoma");
        State s4 = new State("Kansas");
        State s5 = new State("Arkansas");

        s1.adj.add(s2);
        s2.adj.add(s1);

        s1.adj.add(s3);
        s3.adj.add(s1);

        s1.adj.add(s5);
        s5.adj.add(s1);

        s2.adj.add(s5);
        s5.adj.add(s2);

        s3.adj.add(s4);
        s4.adj.add(s3);

        s2.adj.add(s4);
        s4.adj.add(s2);

        String[] dict = new String[]{"tcko", "tex", "califor", "arb", "oklkancaltearkansas"};
        State[] states = new State[] {s1, s2, s3, s4, s5};

        longestWord(states, dict);
    }
}
