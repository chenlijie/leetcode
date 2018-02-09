package airbnb;

import java.util.*;


public class Palindrome_Pairs_336 {

    public List<List<Integer>> palindromePairs(String[] words) {

        Map<String, Integer> loc = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            loc.put(words[i], i);
        }

        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < words.length; i++) {

            char[] c = words[i].toCharArray();
            int len = c.length;
            reverse(c);

            for (int j = 0; j <= len; j++) {
                String key = new String(c, j, len - j);
                if (j <= 1) {
                    if (loc.containsKey(key) && loc.get(key) != i) {
                        ans.add(Arrays.asList(i, loc.get(key)));
                    }
                } else {
                    if (isPalidrome(c, 0, j-1)) {
                        if (loc.containsKey(key)) {
                            ans.add(Arrays.asList(i, loc.get(key)));
                        }
                    }
                }
            }

            for (int j = len; j >= 0; j--) {
                String key = new String(c, 0, j);
                if (j >= len - 1) {
                    if (loc.containsKey(key) && loc.get(key) != i) {
                        ans.add(Arrays.asList(loc.get(key), i));
                    }
                } else {
                    if (isPalidrome(c, j, len-1)) {
                        if (loc.containsKey(key)) {
                            ans.add(Arrays.asList(loc.get(key), i));
                        }
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }

    boolean isPalidrome(char[] c, int i, int j) {
        while (i < j &&c[i] == c[j]) {
            i++;
            j--;
        }
        return i >= j;
    }

    void reverse(char[] c) {
        int i = 0;
        int j = c.length - 1;
        while (i < j) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Palindrome_Pairs_336 p = new Palindrome_Pairs_336();
        System.out.println(p.palindromePairs(new String[]{"a",""}));
    }

}
