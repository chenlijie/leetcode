package oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlijie on 11/29/17.
 */
public class SwapParking {

    static class Moving {
        public Moving(String name, String from, String to) {
            this.name = name;
            this.from = from;
            this.to = to;
        }

        String name;
        String from;
        String to;
    }

    List<String[]> swapping(List<Moving> movings) {
        List<String[]> res = new ArrayList<>();
        Map<String, List<Moving>> map = new HashMap<>();

        for (Moving m : movings) {
            String key = m.to + m.from;
            if (map.containsKey(key) && !map.get(key).isEmpty()) {
                res.add(new String[]{m.name, map.get(m.to + m.from).get(0).name});
                map.get(key).remove(0);
            } else {
                key = m.from + m.to;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(m);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Moving> movings = new ArrayList<>();
        Moving m1= new Moving("Jimmy", "b1", "b2");
        Moving m4= new Moving("Merry", "b1", "b3");
        Moving m5= new Moving("Frank", "b1", "b2");

        Moving m2= new Moving("Jack", "b2", "b1");

        Moving m3= new Moving("Freja", "b2", "b1");

        Moving m6= new Moving("Mike", "b3", "b4");
        movings.add(m1);
        movings.add(m2);
        movings.add(m3);
        movings.add(m4);
        movings.add(m5);
        movings.add(m6);

//        SwapParking s = new SwapParking();
//        System.out.println(s.swapping(movings));

        System.out.println("a" + "1".substring(1) + "a");
        System.out.println((int)'z');
        System.out.println((int)'Z');
    }
}
