package amazon.onsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Decoding {

    static int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;

        Map<Integer, Character> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            map.put(i, (char)('A' + i - 1));
        }

        List<String> list1 = new ArrayList<>();
        list1.add("");
        List<String> list2 = new ArrayList<>();
        list2.add("" + map.get(Integer.parseInt(s.substring(0, 1))));

        for (int i = 2; i <= s.length(); i++) {
            int pre = s.charAt(i - 2) - '0';
            int cur = s.charAt(i - 1) - '0';

            List<String> list = new ArrayList<>();

            if (cur >= 1 && cur <= 9) {
                for (String str : list2) {
                    list.add(str + map.get(cur));
                }
            }

            if (pre == 1 || (pre == 2 && cur < 7)) {
                for (String str : list1) {
                    list.add(str + map.get(pre * 10 + cur));
                }
            }

            list1 = list2;
            list2 = list;

        }

        System.out.println(list2);
        return list2.size();
    }

    static Map<Integer, Character> map = new HashMap<>();

    static {
        for (int i = 1; i <= 26; i++) {
            map.put(i, (char)('A' + i - 1));
        }

    }
    static int numDecodings2(String s) {
        List<String> list = new ArrayList<>();
        helper(s, 0, new StringBuilder(), list);
        System.out.println(list);
        return list.size();
    }

    static void helper(String s, int i, StringBuilder builder, List<String> list) {
        if (i == s.length()) {
            list.add(builder.toString());
            return;
        }

        int len = builder.length();
        int cur = s.charAt(i) - '0';

        if (map.containsKey(cur)) {
            builder.append(map.get(cur));
            helper(s, i + 1, builder, list);
            builder.setLength(len);
        }

        if (i < s.length() - 1) {
            int next = s.charAt(i + 1) - '0';

            if (map.containsKey(cur * 10 + next)) {
                builder.append(map.get(cur * 10 + next));
                helper(s, i + 2, builder, list);
                builder.setLength(len);
            }
        }
    }

    public static void main(String[] args) {
//        numDecodings("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948");

        numDecodings2("1110");
    }
}
