package medium;

import java.util.*;

/**
 * Created by chenlijie on 10/23/17.
 */
public class Palindrome_Partitioning_131 {

    public List<List<String>> partition(String s) {
        if (s == null) {
            return null;
        }

        Map<String, Boolean> map = new HashMap<>();
        List<List<String>> results = new ArrayList<>();
        List<String> result = new ArrayList<>();
        result.add(s.substring(0, 1));
        map.put(s.substring(0, 1), true);
        results.add(result);

        for (int i = 1; i < s.length(); i++) {
            List<List<String>> temp = new ArrayList<>();
            addNewWord(s.substring(i, i+1), results, map, temp);
            appendToLastWord(s.substring(i, i+1), results, map, temp);
            results = temp;
        }

        Iterator<List<String>> it = results.iterator();
        while (it.hasNext()) {
            List<String> list = it.next();
            if (!map.get(list.get(list.size() - 1))) {
                it.remove();
            }
        }

        return results;
    }

    void addNewWord(String s, List<List<String>> results, Map<String, Boolean> map, List<List<String>> temp) {
        for (List<String> result : results) {
            if (map.get(result.get(result.size() - 1))) {
                List<String> list = new ArrayList<>(result);
                list.add(s);
                temp.add(list);
                map.put(s, Boolean.TRUE);
            }
        }
    }

    void appendToLastWord(String s, List<List<String>> results, Map<String, Boolean> map, List<List<String>> temp) {

        for (List<String> result : results) {
            String newWord = result.get(result.size() - 1) + s;

            boolean palindrome = isPalindrome(newWord);

            result.remove(result.size() - 1);
            result.add(newWord);
            temp.add(result);
            map.put(newWord, palindrome);
        }
    }

    boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Palindrome_Partitioning_131().partition("aab"));

//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//
//        Iterator<String> it = list.iterator();
//
//        while (it.hasNext()) {
//            if ("a".equals(it.next())) {
//                list.add("c");
//            }
//        }
//
//        System.out.println(list);
    }
}
