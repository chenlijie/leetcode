package ebay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CrossEachOther {


    static boolean crossEachOther(int[] x) {
        Map<Integer, Set<Integer>> pos = new HashMap<>();
        pos.putIfAbsent(0, new HashSet<>());
        pos.get(0).add(0);

        int a = 0;
        int b = 0;

        for (int i = 0; i < x.length; i++) {

            switch (i % 4) {
                case 0:
                    for (int j = a - x[i]; j < a; j++) {
                        if (pos.containsKey(j) && pos.get(j).contains(b))
                            return true;
                        pos.putIfAbsent(j, new HashSet<>());
                        pos.get(j).add(b);
                    }
                    a -= x[i];
                    break;
                case 1:
                    for (int j = b - x[i]; j < b; j++) {
                        if (pos.containsKey(a) && pos.get(a).contains(j))
                            return true;
                        pos.putIfAbsent(a, new HashSet<>());
                        pos.get(a).add(j);
                    }
                    b -= x[i];
                    break;
                case 2:
                    for (int j = a + 1; j <= a + x[i]; j++) {
                        if (pos.containsKey(j) && pos.get(j).contains(b))
                            return true;
                        pos.putIfAbsent(j, new HashSet<>());
                        pos.get(j).add(b);
                    }
                    a += x[i];
                    break;
                case 3:
                    for (int j = b + 1; j <= b + x[i]; j++) {
                        if (pos.containsKey(a) && pos.get(a).contains(j))
                            return true;
                        pos.putIfAbsent(a, new HashSet<>());
                        pos.get(a).add(j);
                    }
                    b += x[i];
                    break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(crossEachOther(new int[] {1, 1, 2, 2, 2, 0}));
    }
}
