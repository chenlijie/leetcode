package amazon.onsite;

import java.util.*;

public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Map<String, Integer> ladders = new HashMap<>();
        ladders.put(beginWord, 0);
        ladders.put(endWord, Integer.MAX_VALUE);

        for (String s : wordList)
            ladders.put(s, Integer.MAX_VALUE);

        Map<String, List<String>> adjs = new HashMap<>();
        int min = Integer.MAX_VALUE;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while (!q.isEmpty()) {

            String v = q.poll();
            int step = ladders.get(v) + 1;
            if (step > min) break;

            char[] c = v.toCharArray();
            for (int k = 0; k < c.length; k++) {
                char original = c[k];

                for (char j = 'a'; j <= 'z'; j++) {
                    if (j != original) {
                        c[k] = j;
                        String str = new String(c);

                        if (ladders.containsKey(str)) {
                            if (step > ladders.get(str)) {
                                continue;
                            } else if (step < ladders.get(str)) {
                                q.offer(str);
                                ladders.put(str, step);
                            }

                            adjs.putIfAbsent(str, new ArrayList<>());
                            adjs.get(str).add(v);

                            if (str.equals(endWord))
                                min = step;
                        }
                    }
                }

                c[k] = original;
            }
        }

        List<List<String>> finds = new ArrayList<>();
        dfs(endWord, beginWord, adjs, new ArrayList<>(), finds);
        return finds;
    }


    void dfs(String w, String b, Map<String, List<String>> pres, List<String> list, List<List<String>> result) {
        if (w.equals(b)) {
            List<String> r = new ArrayList<>(list);
            r.add(b);
            Collections.reverse(r);
            result.add(r);
            return;
        }

        list.add(w);
        if (pres.containsKey(w)) {
            for (String s : pres.get(w)) {
                dfs(s, b, pres, list, result);
            }
        }

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        WordLadder2 w = new WordLadder2();
        List list = w.findLadders("red", "tax", Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
//                w.findLadders("hot", "dog", Arrays.asList("hot","dog","dot"));
//                w.findLadders("a", "c", Arrays.asList("a","b","c"));
//                w.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(list);
    }
}
