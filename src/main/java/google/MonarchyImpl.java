package google;

import java.util.*;

/**
 * Created by chenlijie on 11/14/17.
 */
public class MonarchyImpl implements Monarchy {

    Map<String, List<String>> rel = new TreeMap<>();
    Set<String> death = new HashSet<>();

    @Override
    public void birth(String child, String parent) {
        rel.putIfAbsent(parent, new ArrayList<>());
        rel.get(parent).add(child);
    }

    @Override
    public void death(String name) {
        death.add(name);
    }

    @Override
    public List<String> getOrderOfSuccession() {
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (String parent : rel.keySet()) {
            dfs(parent, visited, result);
        }
        return result;
    }

    void dfs(String parent, Set<String> visited, List<String> result) {
        if (!visited.contains(parent)) {
            visited.add(parent);
            if (!death.contains(parent)) {
                result.add(parent);
            }

            if (rel.containsKey(parent)) {
                for (String c : rel.get(parent)) {
                    dfs(c, visited, result);
                }
            }
        }
    }

    public List<String> getOrderOfSuccessionBFS() {
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        for (String parent : rel.keySet()) {
            if (!visited.contains(parent)) {
                queue.add(parent);

                while (!queue.isEmpty()) {
                    String p = queue.poll();
                    visited.add(p);
                    if (!death.contains(p)) {
                        result.add(p);
                    }

                    if (rel.containsKey(p)) {
                        for (String c : rel.get(p)) {
                            if (!visited.contains(c)) {
                                queue.offer(c);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MonarchyImpl m = new MonarchyImpl();
        m.birth("A2", "A1");
        m.birth("A3", "A1");
        m.birth("A4", "A2");
        m.birth("A5", "A2");
        m.birth("A7", "A6");
        m.birth("A8", "A6");

        System.out.println(m.getOrderOfSuccession());
        System.out.println(m.getOrderOfSuccessionBFS());
        m.death("A2");
        System.out.println(m.getOrderOfSuccession());
        System.out.println(m.getOrderOfSuccessionBFS());

        System.out.println(Integer.valueOf("01"));
    }


}
