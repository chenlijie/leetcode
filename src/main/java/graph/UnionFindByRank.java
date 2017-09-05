package graph;

/**
 * Created by chenlijie on 8/31/17.
 */

//Detect cycle in an undirected graph
public class UnionFindByRank {

    static class Edge {
        int src;
        int dest;
    }

    static class Subset {
        int parent;
        int rank;
    }

    static class Graph {
        int v;
        int e;
        Edge edge[];

        public Graph(int v, int e, Edge[] edge) {
            this.v = v;
            this.e = e;
            this.edge = edge;

            for (int i = 0; i < e; i++) {
                edge[i] = new Edge();
            }
        }

        public Subset find(int s, Subset[] subsets) {
            if (subsets[s].parent != 0) {
                subsets[s].parent = find(subsets[s].parent, subsets).parent;
            }
            return subsets[s];
        }

        public void union(Subset s1, Subset s2) {
            if (s1.rank < s2.rank) {
                s1.parent = s2.parent;
            } else if (s1.rank > s2.rank) {
                s2.parent = s1.parent;
            } else {
                s1.parent = s2.parent;
                s2.rank++;
            }
        }

        public boolean isCyclic() {

            Subset[] subsets = new Subset[v];
            for (int i = 0; i < v; i++) {
                subsets[i] = new Subset();
            }

            for (int i = 0; i < e; i++) {
                Subset s1 = find(edge[i].src, subsets);
                Subset s2 = find(edge[i].dest, subsets);

                if (s1.parent == s2.parent) {
                    return true;
                }

                union(s1, s2);
            }

            return false;
        }

    }

    public static void main(String[] args) {
        int V = 3, E = 3;

        // add edge 0-1
        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
        }

        edges[0].src = 0;
        edges[0].dest = 1;

        // add edge 1-2
        edges[1].src = 1;
        edges[1].dest = 2;

        // add edge 0-2
        edges[2].src = 0;
        edges[2].dest = 2;

        if (new Graph(V, E, edges).isCyclic())
            System.out.println("Graph contains cycle" );
        else
            System.out.println( "Graph doesn't contain cycle" );
    }
}
