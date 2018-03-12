package airbnb;

import java.util.*;

public class Test {

    static String[] paginate2(int num, String[] results) {
        List<String> list = Arrays.asList(results);

        List<String> ans = new ArrayList<>();

        while (!list.isEmpty()) {
            int i = 0;
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
            Iterator<String> it = list.iterator();

            while (i < num && it.hasNext()) {
                String next = it.next();
                String key = next.substring(0, next.indexOf(','));
                if (!map.containsKey(key)) {
//                    ans.add(next);
//                    map.put(key, next);
                    i++;
                    it.remove();
                }
            }

            if (i < num) {
                it = list.iterator();

                while (i < num && it.hasNext()) {
                    ans.add(it.next());
                    i++;
                    it.remove();
                }
            }

            if (i == num) {
                ans.add("");
            }
        }

        return ans.toArray(new String[ans.size()]);
    }


    static String[] paginate(int num, String[] results) {
        LinkedHashMap<String, Queue<String>> map = new LinkedHashMap<>();

        for (String r : results) {
            String hostId = r.substring(0, r.indexOf(','));
            map.putIfAbsent(hostId, new LinkedList<>());
            map.get(hostId).add(r);
        }

        List<String> ans = new ArrayList<>();

        Collection<Queue<String>> collection = map.values();
        Iterator<Queue<String>> coIt = collection.iterator();

        while (coIt.hasNext()) {
            int i = 0;
            while (i < num && coIt.hasNext()) {
                Queue<String> q = coIt.next();
                if (!q.isEmpty()) {
                    ans.add(q.poll());
                    i++;
                } else {
                    coIt.remove();
                }
            }

            coIt = collection.iterator();
            while (i < num && coIt.hasNext()) {
                Queue<String> q = coIt.next();
                while (i < num && !q.isEmpty()) {
                    ans.add(q.poll());
                    i++;
                }
                if (q.isEmpty()) {
                    coIt.remove();
                }
            }

            if (i == num) {
                ans.add("");
            }
        }

        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args) {

        int num = 5;
        String[] r = new String[]{
                "1, 28, 300.6, San Francisco",
                "4, 5, 209.1, San Francisco ",
                "20, 7, 203.4, Oakland",
                "6, 8, 202.9, San Francisco ",
                "6, 10, 199.8, San Francisco",
                "1, 16, 190.5, San Francisco",
                "6, 29, 185.3, San Francisco",
                "7, 20, 180.0, Oakland",
                "6, 21, 162.2, San Francisco",
                "2, 18, 161.7, San Jose",
                "2, 30, 149.8, San Jose",
                "3, 76, 146.7, San Francisco",
                "2, 14, 141.8, San Jose"
        };

        List<String> list = new ArrayList<>();
        for (String s : r) {
            list.add(s);
        }

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        Iterator<String> it = list.iterator();
        int i = 0;
        if (!list.isEmpty()) {
            while (i < num && it.hasNext()) {
                String next = it.next();
                String key = next.substring(0, next.indexOf(','));
                if (!map.containsKey(key)) {
                    i++;
                    it.remove();
                    map.put(key, next);
                }
            }
        }


//        for (String s : paginate2(num, r)) {
//            System.out.println(s);
//        }
    }


}
