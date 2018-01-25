package facebook.fblist;

import java.util.*;

public class MergeSets {

//    给⼀一些sets，保证每个set内元素不不重复，如果两个sets有任何共同元素，则让其合并，直到不不能
//    合并为⽌止。输出最后的sets的状态。
//    栗栗⼦子，Input: {1,2},{2,3},{3,4}{5,6,7},{7,8},{9},{9}
//    Output: {1,2,3,4},{5,6,7,8},{9}
//    着重在分析时间复杂度，说完思路路、写代码前要先分析好。请以后⼤大家多注意。
//    链接：http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=298581&ctid=456

    List<List<Integer>> mergeSets(List<List<Integer>> sets) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer> set : sets) {
            for (int i = 0; i < set.size(); i++) {
                int u = set.get(i);
                graph.putIfAbsent(u, new ArrayList<>());

                if (i != 0) {
                    int v = set.get(i - 1);
                    graph.get(u).add(v);
                    graph.get(v).add(u);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int u = entry.getKey();

            if (!visited.contains(u)) {
                queue.offer(u);
                List<Integer> component = new ArrayList<>();

                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    visited.add(cur);
                    component.add(cur);

                    for (int adj : graph.get(cur)) {
                        if (!visited.contains(adj)) {
                            queue.offer(adj);
                            visited.add(adj);
                        }
                    }
                }
                ans.add(component);
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        MergeSets obj = new MergeSets();
        int[][] input = {{1,2},{2,3},{3,4},{5,6,7},{7,8},{9,15},{9,16}};
        List<List<Integer>> sets = new ArrayList<>();
        for(int[] nums : input) {
            List<Integer> set = new ArrayList<>();
            for(int num : nums) {
                set.add(num);
            }
            sets.add(new ArrayList<Integer>(set));
        }

        for(List<Integer> set : sets) {
            System.out.println(set);
        }

        System.out.println("After merge:");

        for(List<Integer> set : obj.mergeSets(sets)) {
            System.out.println(set);
        }

    }
}
