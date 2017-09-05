package graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by chenlijie on 8/30/17.
 */
public class GraphBFS {

    int v;
    LinkedList<Integer>[] adj;

    public GraphBFS(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {

        boolean[] visited = new boolean[v];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {

            int from = queue.pollFirst();
            System.out.print(from + " ");

            Iterator<Integer> iterator = adj[from].iterator();
            while (iterator.hasNext()) {

                int next = iterator.next();
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS g = new GraphBFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);
    }

}
