package amazon.onsite;

import java.util.*;

public class ChePiao {

    //https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=477688&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%255B3089%255D%255Bvalue%255D%255B3%255D%3D3%26searchoption%255B3089%255D%255Btype%255D%3Dcheckbox%26searchoption%255B3046%255D%255Bvalue%255D%3D5%26searchoption%255B3046%255D%255Btype%255D%3Dradio%26searchoption%255B3109%255D%255Bvalue%255D%3D2%26searchoption%255B3109%255D%255Btype%255D%3Dradio%26orderby%3Ddateline&page=1
    //给你一堆车票，每张车票有出发地和目的地名字，求整个行程的路线图。

    public static List<String> solution(String[][] tickets) {
        if (tickets == null || tickets.length == 0) return new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        Map<String, Integer> degree = new HashMap<>();
        for (String[] t : tickets) {
            map.put(t[0], t[1]);
            degree.put(t[0], degree.getOrDefault(t[0], 0) + 1);
            degree.put(t[1], degree.getOrDefault(t[1], 0) - 1);
        }

        String start = null;
        for (Map.Entry<String, Integer> e : degree.entrySet()) {
            if (e.getValue() == 1) {
                start = e.getKey();
                break;
            }
        }

        List<String> ans = new ArrayList<>();
        ans.add(start);

        while (map.containsKey(start)) {
            ans.add(map.get(start));
            start = map.get(start);
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        String[][] tickets = new String[][] {
                {"d", "e"},
                {"c", "d"},
                {"b", "c"},
                {"a", "b"},
        };
        solution(tickets);
    }
}
