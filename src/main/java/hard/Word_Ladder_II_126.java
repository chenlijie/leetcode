package hard;

import medium.Word_Ladder_127;

import java.util.*;

/**
 * Created by chenlijie on 8/5/17.
 */
public class Word_Ladder_II_126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> finds = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> exist = new HashSet<>();
        queue.add(beginWord);
        Map<String, List<List<String>>> map = new HashMap<>();
        map.putIfAbsent(beginWord, new ArrayList<>());
        map.get(beginWord).add(Arrays.asList(beginWord));
        boolean find = false;

        while (queue.size() != 0) {
            if (find) {
                return finds;
            }

            int size = queue.size();

            List<String> toBeExist = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                String str = queue.poll();
                List<String> words = new ArrayList<>();

                for (int j = 0; j < wordList.size(); j++) {
                    if (!exist.contains(wordList.get(j))) {
                        if (oneDiff(wordList.get(j), str)) {

                            map.putIfAbsent(wordList.get(j), new ArrayList<>());

                            for (List<String> list : map.get(str)) {
                                List<String> newList = new ArrayList<>();
                                newList.addAll(list);
                                newList.add(wordList.get(j));
                                map.get(wordList.get(j)).add(newList);
                            }

                            if (endWord.equals(wordList.get(j))) {

                                for (List<String> list : map.get(str)) {
                                    list.add(endWord);
                                }

                                finds.addAll(map.get(str));

                                words.add(endWord);
                                find = true;
                            } else {
                                toBeExist.add(wordList.get(j));
                                queue.add(wordList.get(j));
                                words.add(wordList.get(j));
                            }

                        } else {
                            words.add(wordList.get(j));
                        }
                    }
                }
                wordList = words;
            }
            exist.addAll(toBeExist);
        }

        return finds;
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

        return c == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Word_Ladder_II_126().findLadders("red", "tax", Arrays.asList("ted","tex", "tax","den","rex","pee")));
    }
}
