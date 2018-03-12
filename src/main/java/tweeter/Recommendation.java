package tweeter;

import java.util.*;

public class Recommendation {

//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=304642&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D20%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

    static List<String> getRecommendations(String[][] follows, String[][] likes, String target, int minLikes) {
        Set<String> set = new HashSet<>();

        for (String[] s : follows) {
            if (target.equals(s[0]))
                set.add(s[1]);
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String[] like : likes) {
            if (set.contains(like[0])) {
                map.putIfAbsent(like[1], new ArrayList<>());
                map.get(like[1]).add(like[0]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            if (e.getValue().size() >= minLikes) {
                ans.add(e.getKey());
            }
        }

        System.out.println(ans);

        return ans;
    }

    public static void main(String[] args) {
        String[][] follows = new String[][] {
                {"A", "B"},
                {"A", "C"},
                {"A", "D"},
                {"B", "E"}
        };
        String[][] likes = new String[][] {
                {"B", "T1"},
                {"E", "T2"},
                {"D", "T1"},
                {"D", "T2"}
        };

        getRecommendations(follows, likes, "A", 1);
    }
}
