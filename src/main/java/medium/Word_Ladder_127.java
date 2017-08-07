package medium;

import java.util.*;

/**
 * Created by chenlijie on 8/2/17.
 */
public class Word_Ladder_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
//        boolean[] exist = new boolean[wordList.size()];
        Set<String> exist = new HashSet<>();
        queue.add(beginWord);
        int len = 0;


        while (queue.size() != 0) {
            len++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String str = queue.poll();
                List<String> words = new ArrayList<>();

                for (int j = 0; j < wordList.size(); j++) {
                    if (!exist.contains(wordList.get(j))) {
                        if (oneDiff(wordList.get(j), str)) {
                            if (endWord.equals(wordList.get(j))) {
                                return ++len;
                            }
                            exist.add(wordList.get(j));
                            queue.add(wordList.get(j));
                        } else {
                            words.add(wordList.get(j));
                        }
                    }
                }
                wordList = words;
            }
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

    public static void main(String[] args) {
        System.out.println(new Word_Ladder_127().ladderLength("hit", "hab", Arrays.asList("hat", "hab")));
    }
}
