package oa;

import java.util.*;

/**
 * Created by chenlijie on 11/24/17.
 */
public class ShortestSequence {

    static List<Integer> getShortestLength(List<Character> list) {

        List<Integer> result = new ArrayList<>();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            int last = getLastIdx(list.get(i), list, i);

            int j = i + 1;
            while (j < last) {
                int k = getLastIdx(list.get(j), list, j);
                if (k > last) {
                    last = k;
                }
                j++;
            }
            result.add(last+1-i);
            i = last;
        }
        return result;
    }

    static int getLastIdx(char c, List<Character> list, int j) {
        for (int i = list.size()-1; i > j ; i--) {
            if (c == list.get(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        for (char c : "abcdabefghije".toCharArray()) {
            list.add(c);
        }

        System.out.println(getShortestLength(list));
        LinkedList<Integer> queue = new LinkedList<>();
        queue.removeLast();
    }
}
