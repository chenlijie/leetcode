package graph;

/**
 * Created by chenlijie on 8/31/17.
 */

//Detect cycle in an undirected graph
public class UnionFind {

    public boolean isCyclic(int[][] edges, int num) {

        int[] parent = new int[num];

        for (int i = 0; i < num; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < edges.length; i++) {
            int p0 = findParent(edges[i][0], parent);
            int p1 = findParent(edges[i][1], parent);

            if (p0 == p1) {
                return true;
            } else {
                parent[edges[i][0]] = p1;
            }
        }

        return false;
    }

    private int findParent(int s, int[] parent) {
        if (parent[s] != -1) {
            return findParent(parent[s], parent);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new UnionFind().isCyclic(new int[][]{
                {2, 3},
                {0, 1},
                {1, 2},
                {3, 4},
                {1, 3}
        }, 5));
    }
}
