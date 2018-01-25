package medium;

import java.util.*;

public class Top_K_Frequent_Words_692 {


    static List<String> topKFrequent(String[] words, int k) {

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((e1, e2) -> e1.getValue() == e2.getValue() ? e2.getKey().compareTo(e1.getKey()) : e1.getValue() - e2.getValue());

        Map<String, Integer> occurences = new HashMap<>();
        for (String word : words) {
            occurences.put(word, occurences.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : occurences.entrySet()) {
            queue.offer(e);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> ans = new ArrayList<>(queue.size());

        while (!queue.isEmpty()) {
            ans.add(queue.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}
