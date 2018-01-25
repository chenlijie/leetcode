package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chenlijie on 11/17/17.
 */
public class Minimum_Height_Trees_310 {

    static List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0)
            return new ArrayList<>();

        List<Integer>[] adjacent = new List[n];
        for (int i = 0; i < n; i++) {
            adjacent[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        for (int[] e : edges) {
            indegree[e[0]]++;
            indegree[e[1]]++;
            adjacent[e[0]].add(e[1]);
            adjacent[e[1]].add(e[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                res.add(num);
                indegree[num]--;
                visited[num] = true;

                for (Integer a : adjacent[num]) {
                    if (!visited[a] && --indegree[a] == 1) {
                        queue.offer(a);
                    }
                }
            }

            if (isAllVisited(visited)) {
                return res;
            }
        }

        return new ArrayList<>();
    }

    static boolean isAllVisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList();
        }

        int[] counts = new int[n];
        for (int[] e : edges) {
            counts[e[0]]++;
            counts[e[1]]++;
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (counts[i] == 1) {
                queue.offer(i);
                ans.add(i);
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int v = queue.poll();

                for (int j = 0; j < adj[v].size(); j++) {
                    int u = (int)adj[v].get(j);
                    if (--counts[u] == 1) {
                        queue.offer(u);
                        temp.add(u);
                    }
                }
            }

            if (queue.isEmpty()) {
                return ans;
            }
            ans = temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{0,1}, {1,2}, {1,3}};

        System.out.println(findMinHeightTrees(4, edges));
    }
}
