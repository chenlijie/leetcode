package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chenlijie on 12/20/17.
 */
public class Graph_Valid_Tree_261 {

    /*static class Node {
        int parent;
        int rank;
    }
    public boolean validTree(int n, int[][] edges) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].parent = i;
        }

        for (int[] e : edges) {
            Node node1 = find(e[0], nodes);
            Node node2 = find(e[1], nodes);

            if (node1.parent == node2.parent) {
                return false;
            } else {
                if (node1.rank > node2.rank) {
                    node2.parent = node1.parent;
                } else if (node1.rank < node2.rank) {
                    node1.parent = node2.parent;
                } else {
                    node2.parent = node1.parent;
                    node1.rank++;
                }
            }
        }

        boolean find = false;
        for (int i = 0; i < n; i++) {
            if (nodes[i].parent == i) {
                if (find) {
                    return false;
                }
                find = true;
            }
        }
        return true;
    }

    Node find(int i, Node[] nodes) {
        if (i == nodes[i].parent)
            return nodes[i];

        return find(nodes[i].parent, nodes);
    }*/

    public boolean validTree(int n, int[][] edges) {
        List[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[n];
        if (isCyclic(0, visited, -1, adj))
            return false;

        for (boolean b : visited) {
            if (!b) return false;
        }

        return true;
    }

    boolean isCyclic(int v, boolean[] visited, int p, List[] adj) {
        if (!visited[v]) {
            visited[v] = true;

            for (int i = 0; i < adj[v].size(); i++) {
                int u = (int)adj[v].get(i);
                if (!visited[u] ) {
                    if (isCyclic(u, visited, v, adj))
                        return true;
                } else if (u != p) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Graph_Valid_Tree_261 g = new Graph_Valid_Tree_261();

        System.out.println(g.validTree(2, new int[][]{
                {0, 1}
        }));
    }
}
