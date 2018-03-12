package medium;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Open_the_Lock_752 {

    static int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Collections.addAll(visited, deadends);

        if (visited.contains("0000")) return -1;

        Set<String> head = new HashSet<>();
        head.add("0000");

        Set<String> tail = new HashSet<>();
        tail.add(target);

        visited.add("0000");
        visited.add(target);

        int step = 0;

        while (!head.isEmpty() && !tail.isEmpty()) {
            Set<String> temp = new HashSet<>();
            step++;

            for (String v : head) {

                char[] c = v.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char num = c[j];
                    c[j] = num == '9' ? '0' : (char)(num + 1);

                    String newNext = new String(c);
                    if (tail.contains(newNext)) return step;

                    if (visited.add(newNext))
                        temp.add(newNext);

                    c[j] = num == '0' ? '9' : (char)(num - 1);

                    newNext = new String(c);
                    if (tail.contains(newNext)) return step;
                    if (visited.add(newNext))
                        temp.add(newNext);

                    c[j] = num;
                }
            }

            if (temp.size() < tail.size()) {
                head = temp;
            } else {
                head = tail;
                tail = temp;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"));
    }
}
