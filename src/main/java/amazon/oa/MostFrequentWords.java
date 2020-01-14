package amazon.oa;

import java.util.*;

public class MostFrequentWords {

    static List<String> mostFrequentWords(String sentence, List<String> excludedList) {

        Set<String> set = new HashSet<>();
        for (String s : excludedList)
            set.add(s.toLowerCase());

        Map<String, Integer> counts = new HashMap<>();
        int max = 0;
        int len = sentence.length();
        char[] c = sentence.toCharArray();
        int i = 0;

        while (i < len) {
            while (i < len && !Character.isLetter(c[i]) && !Character.isDigit(c[i])) i++;

            int j = i;
            while (j < len && (Character.isLetter(c[j]) || Character.isDigit(c[j]))) j++;

            if (j > i) {
                String word = new String(c, i, j - i).toLowerCase();
                if (!set.contains(word)) {
                    int cnt = counts.getOrDefault(word, 0) + 1;
                    counts.put(word, cnt);
                    if (cnt > max) {
                        max = cnt;
                    }
                }
            }
            i = j;
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> e : counts.entrySet()) {
            if (e.getValue() == max)
                ans.add(e.getKey());
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        String words = "This implementation provides constant-time performance for the basic operations (get and put), " +
                "assuming the hash function disperses the elements properly 123 among the buckets. Iteration over collection " +
                "views requires time proportional to the \"capacity\" of the HashMap instance (the number of buckets) plus " +
                "its size (the number of key-value mappings). Thus, it's very important not to set the initial capacity too" +
                " high (or the load factor too low) if iteration performance is important.";

        mostFrequentWords(words, Arrays.asList("Iteration", "the", "of", "time", "number", "buckets", "important", "capacity", "too", "performance", "to"));

    }
}
