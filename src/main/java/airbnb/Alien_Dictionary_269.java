package airbnb;

import java.util.*;

public class Alien_Dictionary_269 {

    public String alienOrder(String[] words) {
        List<String> orders = new ArrayList<>();
        getOrders(Arrays.asList(words), 0, orders);

        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indgree = new HashMap<>();
        Set<Character> letters = new HashSet<>();

        for (String order : orders) {
            char[] c = order.toCharArray();
            for (int i = 0; i < c.length - 1; i++) {
                adj.putIfAbsent(c[i], new ArrayList<>());
                adj.get(c[i]).add(c[i + 1]);

                indgree.put(c[i + 1], indgree.getOrDefault(c[i + 1], 0) + 1);
            }
        }

        for (String w : words) {
            for (char c : w.toCharArray()) {
                letters.add(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (char c : letters) {
            if (!indgree.containsKey(c)) {
                q.offer(c);
            }
        }

        while (!q.isEmpty()) {
            char v = q.poll();
            ans.append(v);
            letters.remove(v);

            if (adj.containsKey(v)) {
                for (char c : adj.get(v)) {
                    indgree.put(c, indgree.get(c) - 1);

                    if (indgree.get(c) == 0) {
                        q.offer(c);
                    }
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : indgree.entrySet()) {
            if (entry.getValue() > 0) {
                return "";
            }
        }

        for (Iterator<Character> it = letters.iterator(); it.hasNext();) {
            ans.append(it.next());
        }

        return ans.toString();
    }

    void getOrders(List<String> words, int pos, List<String> orders) {
        int len = words.size();
        StringBuilder order = new StringBuilder();

        for (int i = 0, j = 0; i < len;) {
            List<String> next = new ArrayList<>();
            while (i < len && words.get(i).charAt(pos) == words.get(j).charAt(pos)) {
                if (words.get(i).length() > pos + 1)
                    next.add(words.get(i));
                i++;
            }
            if (next.size() > 1) {
                getOrders(next, pos + 1, orders);
            }
            order.append(words.get(j).charAt(pos));
            j = i;
        }
        orders.add(order.toString());
    }

    public static void main(String[] args) {
        Alien_Dictionary_269 a = new Alien_Dictionary_269();
        System.out.println(a.alienOrder(new String[]{"a","b","ca","cc"}));
    }
}
