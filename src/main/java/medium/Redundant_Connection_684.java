package medium;

import java.util.*;

public class Redundant_Connection_684 {

    static int[] findRedundantConnection(int[][] edges) {
        List<Integer>[] adjs = new List[edges.length + 1];
        for (int i = 0; i < adjs.length; i++) {
            adjs[i] = new ArrayList<>();
        }

        int[] indgree = new int[adjs.length];

        for (int[] e : edges) {
            adjs[e[0]].add(e[1]);
            adjs[e[1]].add(e[0]);
            indgree[e[0]]++;
            indgree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < adjs.length; i++) {
            if (adjs[i].size() == 1) {
                q.add(i);
            }
        }

        Set<Integer> visited = new HashSet<>();

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int v = q.poll();
                visited.add(v);

                for (int u : adjs[v]) {
                    if (!visited.contains(u) && --indgree[u] == 1) {
                        q.offer(u);
                    }
                }
            }
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            if (!visited.contains(edges[i][0]) && !visited.contains(edges[i][1]))
                return edges[i];
        }

        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        findRedundantConnection(new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}});
    }
}
