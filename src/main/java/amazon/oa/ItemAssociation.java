package amazon.oa;

import java.util.*;

public class ItemAssociation {

    static List<String> maxGroup(String[][] str) {
        Map<String, String> parents = new HashMap<>();
        Map<String, List<String>> groups = new HashMap<>();

        for (int i = 0; i < str.length; i++) {
            String p1 = find(str[i][0], parents);
            String p2 = find(str[i][1], parents);

            if (p1.compareTo(p2) < 0) {
                parents.put(p2, p1);

                if (!groups.containsKey(p1)) {
                    groups.put(p1, new ArrayList<>());
                    groups.get(p1).add(p1);
                }

                if (groups.containsKey(p2)) {
                    groups.get(p1).addAll(groups.get(p2));
                } else {
                    groups.get(p1).add(p2);
                }
            } else if (p1.compareTo(p2) > 0) {
                parents.put(p1, p2);

                if (!groups.containsKey(p2)) {
                    groups.put(p2, new ArrayList<>());
                    groups.get(p2).add(p2);
                }

                if (groups.containsKey(p1)) {
                    groups.get(p2).addAll(groups.get(p1));
                } else {
                    groups.get(p2).add(p1);
                }
            }
        }

        String key = null;
        List<String> maxGroup = new ArrayList<>(0);
        for (Map.Entry<String, List<String>> e : groups.entrySet()) {
            if (e.getValue().size() > maxGroup.size()) {
                key = e.getKey();
                maxGroup = e.getValue();
            } else if (e.getValue().size() == maxGroup.size() && e.getKey().compareTo(key) < 0) {
                key = e.getKey();
                maxGroup = e.getValue();
            }
        }

        System.out.println(maxGroup);
        return maxGroup;
    }

    static String find(String s, Map<String, String> parents) {
        if (parents.containsKey(s))
            return find(parents.get(s), parents);

        return s;
    }

    public static void main(String[] args) {
        String[][] str = new String[][] {
                {"item0", "item6"},
                {"item6", "item7"},
                {"item2", "item11"},
                {"item3", "item11"},
//                {"item1", "item4"},
                {"item9", "item10"},
        };

        maxGroup(str);
    }
}
