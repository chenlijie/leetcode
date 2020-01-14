package amazon.oa;

import utility.Utils;

import java.util.*;

public class ShortestSubSequence {

//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=344436&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B5%5D%3D5%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

//    input 大概是这样
//    tag_list = ["made","in","china"]
//    all_tags = ["made", "a","b","c","in", "china","made","b","c","d"].
//    答案则为 [4,6], 不需要保存顺序，只需返回最短的subsequence包含所有tag_list的元素


    //The idea is using slid window.
    //first step is find a window in allTags which contains all words in tags
    //second step is check if we get smaller window by shrinking window
    //repeat 1 and 2 steps
    static int[] subSequence(String[] tags, String[] allTags) {
        if (tags.length == 0 || allTags.length == 0)
            return new int[] {-1, -1};

        //collect count for each word
        Map<String, Integer> counts = new HashMap<>();
        for (String tag : tags) {
            counts.put(tag, counts.getOrDefault(tag, 0) + 1);
        }

        int len = allTags.length;
        int counter = tags.length;
        //if end - start equals MAX_VALUE, there is no such sub sequence
        int start = 0;
        int end = Integer.MAX_VALUE;

        for (int i = 0, j = 0; i < len; i++) {
            //we only care about the word existing in tags list
            if (counts.containsKey(allTags[i])) {
                //if the count of element i is larger than 0, we match one pair
                //decrease counter
                int c = counts.get(allTags[i]);
                if (c > 0) {
                    counter--;
                }
                counts.put(allTags[i], c - 1);
            }

            //we find one sub sequence that contains all words in tag list
            while (counter == 0) {
                //check if sub sequence is smaller than previous one
                if (i - j < end - start) {
                    start = j;
                    end = i;
                }

                if (counts.containsKey(allTags[j])) {
                    //remove one word from current window
                    //if the count is larger than 0, it means the window doesn't contains all the words in tag list
                    int c = counts.get(allTags[j]) + 1;
                    counts.put(allTags[j], c);
                    if (c > 0) {
                        counter++;
                    }
                }
                j++;
            }
        }


        int[] ans = end - start == Integer.MAX_VALUE ? new int[] {-1,-1} : new int[] {start, end};
        Utils.printArray(ans);
        return ans;
    }

    public static List<Integer> subSequenceTags(List<String> targetList, List<String> availableTagList) {
        List<Integer> ret = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String tag : targetList) {
            String tg = tag.toLowerCase();
            map.put(tg, map.getOrDefault(tg, 0) + 1);
        }
        int start = 0, end = 0, counter = targetList.size(), retStart = 0, retEnd = availableTagList.size();
        while (end < availableTagList.size()) {
            String cur = availableTagList.get(end++).toLowerCase();
            map.put(cur, map.getOrDefault(cur, 0) - 1);
            if (map.getOrDefault(cur, 0) >= 0) counter--;
            while (counter == 0) {
                if (end - start < retEnd - retStart + 1) {
                    retStart = start;
                    retEnd = end - 1;
                }
                cur = availableTagList.get(start++).toLowerCase();
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                if (map.get(cur) > 0) counter++;
            }
        }
        ret.add(retStart);
        ret.add(retEnd);

        System.out.println(ret);
        return ret;
    }

    public static void main(String[] args) {
        String[] tag_list = {"made","in","china"};
//        String[] tag_list = new String[] {"b"};
        String[] all_tags = {"made", "a","b","c","in", "china","made","b","c","d"};

        subSequence(tag_list, all_tags);// 4, 6
        subSequenceTags(Arrays.asList("made","in","china"), Arrays.asList("made", "a","b","c","in", "china","made","b","c","d"));// 4, 6
    }
}
