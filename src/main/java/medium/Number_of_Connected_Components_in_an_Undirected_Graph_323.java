package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 11/8/17.
 */
public class Number_of_Connected_Components_in_an_Undirected_Graph_323 {

    static int countComponents(int n, int[][] edges) {
        List[] adj = new List[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < edges.length; i++) {
            if (adj[edges[i][0]] == null) {
                adj[edges[i][0]] = new ArrayList();
            }
            adj[edges[i][0]].add(edges[i][1]);

            if (adj[edges[i][1]] == null) {
                adj[edges[i][1]] = new ArrayList();
            }
            adj[edges[i][1]].add(edges[i][0]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                findComponents(i, adj, visited);
            }
        }
        return count;
    }

    static void findComponents(int i, List[] adj, boolean[] visited) {
        if (!visited[i]) {
            visited[i] = true;

            for (int j = 0; j < adj[i].size(); j++) {
                findComponents((int)adj[i].get(j), adj, visited);
            }
        }
    }

    static int countComponents2(int n, int[][] edges) {
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            int first = findParent(e[0], parent);
            int second = findParent(e[1], parent);

            if (first != second) {
//                parent[second] = first;
                parent[first] = second;
                n--;
            }
        }

        return n;
    }

    static int findParent(int i, int[] parent) {
        if (parent[i] != i) {
            return findParent(parent[i], parent);
        } else {
            return i;
        }

//        while(parent[i] != i) {
//            parent[i] = parent[parent[i]];  // optional: path compression
//            i = parent[i];
//        }
//        return i;
    }

    static class Subset {
        int parent;
        int rank;

        public Subset(int parent) {
            this.parent = parent;
            rank = 0;
        }
    }

    static int countComponents3(int n, int[][] edges) {
        Subset[] parent = new Subset[n];

        for (int i = 0; i < n; i++) {
            parent[i] = new Subset(i);
        }

        for (int[] e : edges) {
            int first = findParent(e[0], parent);
            int second = findParent(e[1], parent);

            if (first != second) {

                if (parent[first].rank < parent[second].rank) {
                    parent[first].parent = second;
                } else if (parent[first].rank > parent[second].rank){
                    parent[second].parent = first;
                } else {
                    parent[second].parent = first;
                    parent[first].rank++;
                }
                n--;
            }
        }

        return n;
    }

    static int findParent(int i, Subset[] parent) {
        if (parent[i].parent != i) {
            return findParent(parent[i].parent, parent);
        } else {
            return i;
        }
    }

    public static void main(String[] args) {
        System.out.println(countComponents3(5, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4},
        }));
    }
}
