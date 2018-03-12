package tweeter;

import java.util.HashSet;
import java.util.Set;

public class Minimum_Genetic_Mutation_433 {

//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=304642&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D20%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

    static int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }

        Set<String> visited = new HashSet<>();
        Set<String> head = new HashSet<>();
        Set<String> tail = new HashSet<>();
        int depth = 0;

        head.add(start);
        tail.add(end);
        char[] mutations = new char[] {'A', 'C', 'G', 'T'};

        while (!head.isEmpty() && !tail.isEmpty()) {

            Set<String> temp = new HashSet<>();
            for (String v : head) {
                visited.add(v);

                char[] c = v.toCharArray();

                for (int i = 0; i < 8; i++) {
                    char original = c[i];
                    for (int j = 0; j < 4; j++) {
                        if (original != mutations[j]) {
                            c[i] = mutations[j];
                            String changed = new String(c);

                            if (tail.contains(changed))
                                return depth + 1;

                            if (bankSet.contains(changed) && !visited.contains(changed)) {
                                // queue.offer(changed);
                                temp.add(changed);
                            }
                            c[i] = original;
                        }
                    }
                }
            }

            if (temp.size() < tail.size()) {
                head = temp;
            } else {
                head = tail;
                tail = temp;
            }
            depth++;
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println(minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
    }
}
