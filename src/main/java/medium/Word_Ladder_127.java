package medium;

import java.util.*;

/**
 * Created by chenlijie on 8/2/17.
 */
public class Word_Ladder_127 {

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        Set<String> qs = new HashSet<>();
        Set<String> qe = new HashSet<>();
        qs.add(beginWord);
        qe.add(endWord);
        int len = 0;

        while (!qs.isEmpty()) {
            len++;

            Set<String> temp = new HashSet<>();

            for (String cur : qs) {
                char[] ch = cur.toCharArray();
                for (int j = 0; j < ch.length; j++) {
                    char t = ch[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (ch[j] != c) {
                            ch[j] = c;
                            String w = new String(ch);

                            if (qe.contains(w)) return len+1;

                            if (dict.contains(w) && !visited.contains(w)) {
                                temp.add(w);
                                visited.add(w);
                            }
                            ch[j] = t;
                        }
                    }
                }
            }
            qs = qe;
            qe = temp;
        }

        return 0;
    }

    private boolean oneDiff(String str1, String str2) {
        int c = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                c++;
            }
            if (c > 1) {
                return false;
            }
        }

        return true;
    }

    static class Node {
        public String name;
        public List<String> adjacent;
        public int path;

        public Node(String name) {
            this.name = name;
            adjacent = new ArrayList<>();
            path = -1;
        }
    }

    static class Graph {
        public String beginWord;
        public String endWord;
        public List<String> wordList;
        public Map<String, Node> map;

        public Graph(String beginWord, String endWord, List<String> wordList) {
            this.beginWord = beginWord;
            this.endWord = endWord;
            map = new HashMap<>();
            Node beginNode = new Node(beginWord);
            beginNode.path = 1;
            map.put(beginWord, beginNode);

            for (String word : wordList) {
                if (!beginWord.equals(word)) {
                    if (isOneLetterDiff(beginWord, word)) {
                        beginNode.adjacent.add(word);
                    }
                    map.put(word, new Node(word));
                }
            }

            for (int i = 0; i < wordList.size() - 1; i++) {
                for (int j = i+1; j < wordList.size(); j++) {
                    String word1 = wordList.get(i);
                    String word2 = wordList.get(j);
                    if (!beginWord.equals(word1) && !beginWord.equals(word2) && isOneLetterDiff(word1, word2) && !map.get(word1).adjacent.contains(word2)) {
                        map.get(word1).adjacent.add(word2);
                        map.get(word2).adjacent.add(word1);
                    }
                }
            }
        }

        public int ladderLength() {
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            boolean find = false;
            int min = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {

                String word = queue.poll();
                visited.add(word);

                for (String w : map.get(word).adjacent) {
                    if (!visited.contains(w)) {
                        queue.offer(w);

                        if (map.get(w).path == -1 || map.get(w).path > map.get(word).path + 1) {
                            map.get(w).path = map.get(word).path + 1;
                        }

                        if (endWord.equals(w)) {
                            find = true;
                            min = Math.min(min, map.get(w).path);
                        }
                    }
                }

                if (find) {
                    return min;
                }
            }

            return -1;
        }

        boolean isOneLetterDiff(String word1, String word2) {
            if (word1.length() != word2.length()) {
                return false;
            }

            int cnt = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    cnt++;
                }
                if (cnt > 1) {
                    return false;
                }
            }
            return true;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return new Graph(beginWord, endWord, wordList).ladderLength();
    }

    public static void main(String[] args) {
//        System.out.println(new Word_Ladder_127().ladderLength("hot", "dog", Arrays.asList("hot","dog","cog","pot","dot")));
        System.out.println(new Word_Ladder_127().ladderLength2("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(new Word_Ladder_127().ladderLength2("hit", "hog", Arrays.asList("hot", "hog")));
    }
}
