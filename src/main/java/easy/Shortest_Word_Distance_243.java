package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 12/7/17.
 */
public class Shortest_Word_Distance_243 {

    /**
     Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

     For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

     Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.

     Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
     */


    static int shortestDistance(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                idx1 = i;
                if (idx2 != -1)
                    min = Math.min(min, idx1 - idx2);
            }

            if (word2.equals(words[i])) {
                idx2 = i;
                if (idx1 != -1)
                    min = Math.min(min, idx2 - idx1);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(shortestDistance(new String[]{"a", "b", "c", "d", "d", "c", "a"}, "a", "d"));
    }
}
