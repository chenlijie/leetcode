package amazon.onsite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidTree {

    class Node {
        int parent = -1;
        int rank = 0;
    }

    private int find(int i, int[] parent) {
        while (parent[i] != -1) {
            i = parent[i];
        }
        return i;
    }

    private int find(int i, Node[] parent) {
        while (parent[i].parent != -1) {
            i = parent[i].parent;
        }
        return i;
    }

    public boolean validTree(int n, int[][] edges) {

        /*Node[] parent = new Node[n];
        for (int i = 0; i < n; i++)
            parent[i] = new Node();

        for (int[] e : edges) {
            int p1 = find(e[0], parent);
            int p2 = find(e[1], parent);

            if (p1 == p2)
                return false;
            else if (parent[p1].rank > parent[p2].rank) {
                parent[p2].parent = p1;
            } else if (parent[p1].rank < parent[p2].rank) {
                parent[p1].parent = p2;
            } else {
                parent[p2].parent = p1;
                parent[p1].rank++;
            }
        }

        int count = 0;
        for (Node p : parent) {
            if (p.parent == -1 && ++count > 1) {
                return false;
            }
        }

        return true;*/

        // BFS
        boolean[] visited = new boolean[n];
        List<Integer>[] adj = new List[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int count = 0;

        while (!q.isEmpty()) {
            int v = q.poll();
            if (visited[v]) return false;

            visited[v] = true;
            count++;

            for (int u : adj[v]) {
                if (!visited[u]) q.offer(u);
            }
        }

        return count == n;


        /*boolean[] visited = new boolean[n];
        List<Integer>[] adj = new List[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        if (isCyclic(0, -1, adj, visited)) return false;

        for (boolean v : visited)
            if (v == false) return false;

        return true;*/
    }

    boolean isCyclic(int i, int p, List<Integer>[] adj, boolean[] visited) {
        if (visited[i]) return true;

        visited[i] = true;

        for (int u : adj[i]) {
            if (u != p && isCyclic(u, i, adj, visited)) return true;
        }

        return false;
    }
}
