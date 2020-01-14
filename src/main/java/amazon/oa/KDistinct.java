package amazon.oa;

import java.util.*;

public class KDistinct {

//    get all substring with k distinct character and length k
//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=344436&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B5%5D%3D5%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311


    static List<String> kDistinct(String s, int k) {
        if (s == null || k > s.length())
            return new ArrayList<>();

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        int len = s.length();
        boolean[] visited = new boolean[256];


        for (int i = 0, j = 0; i < len; i++) {
            char c = s.charAt(i);

            if (!visited[c]) {
                visited[c] = true;
            } else {
                j++;
            }

            if (i - j + 1 == k) {
                set.add(s.substring(j, i + 1));
                list.add(s.substring(j, i + 1));
                visited[s.charAt(j++)] = false;
            }
        }

        System.out.println(set);
        System.out.println(list);
        return new ArrayList<>(set);
    }

    static List<String> kMinusOneDistinct(String s, int k) {
        if (s == null || k - 1 > s.length())
            return new ArrayList<>();

        Set<String> set = new HashSet<>();

        int len = s.length();
        int[] counts = new int[256];


        for (int i = 0, j = 0; i < len; i++) {
            char c = s.charAt(i);

            if (++counts[c] > 2) {
                j++;
            }

            if (i - j + 1 == k) {
                set.add(s.substring(j, i + 1));
                counts[s.charAt(j++)]--;
            }
        }

        System.out.println(set);
        return new ArrayList<>(set);
    }

    static List<String> kDistinctWithOnlyOneDuplicate(String s, int k) {
        if (s == null || k - 1 > s.length())
            return new ArrayList<>();

        Set<String> set = new HashSet<>();
        int len = s.length();
        int[] counts = new int[256];
        int distinct = 0;


        for (int i = 0, j = 0; i < len; i++) {
            char c = s.charAt(i);

            if (counts[c]++ == 0) {
                distinct++;
            }

            if (i - j + 1 == k) {
                if (distinct == k - 1)
                    set.add(s.substring(j, i + 1));
                if (--counts[s.charAt(j++)] == 0)
                    distinct--;
            }
        }

        System.out.println(set);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {

        kDistinct("awaglknagawunagwkwagl", 4);
//        kDistinctWithOnlyOneDuplicate("asdfaghjkjqoiiii", 5);
//        Solution("asdfaghjkjqoiiii", 5);
//
//        kDistinctWithOnlyOneDuplicate("aaabbcccc", 4);
//        Solution("aaabbcccc", 4);
//        kMinusOneDistinct("abcd", 4);
//        kMinusOneDistinct("abcabd", 4);
//        kMinusOneDistinct("abcbca", 3);
//        kMinusOneDistinct("abcbca", 1);
    }

    static List<String> Solution(String s, int N){
        List<String> res = new ArrayList<>();
        if(s == null || N <=0 || s.length() < N) return res;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, dupCount = 0, len = 0;
        for(int right = 0; right < s.length(); right++){
            len++;
            if(!map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), 1);
            }else{
                map.put(s.charAt(right), map.get(s.charAt(right))+1);
                dupCount++;
            }

            while(len == N){
                if(dupCount == 1){
                    String subString = s.substring(left, left + N);
                    res.add(subString);
                }
                if(map.get(s.charAt(left)) >= 2){
                    dupCount--;
                }
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                len--;
                ++left;
            }
        }

        System.out.println(res);
        return res;
    }
}
