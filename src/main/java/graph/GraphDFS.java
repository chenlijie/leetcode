package graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by chenlijie on 8/30/17.
 */
public class GraphDFS {

    int v;
    LinkedList<Integer>[] adj;

    public GraphDFS(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFS(int s) {
        boolean[] visited = new boolean[v];
        DFSUtil(s, visited);

        for (int i = 0; i < v; i++) {
            if (i != s && !visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    void DFSUtil(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");

        Iterator<Integer> i = adj[s].iterator();

        while (i.hasNext()) {
            int next = i.next();
            if (!visited[next]) {
                DFSUtil(next, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphDFS g = new GraphDFS(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(4, 5);

        g.DFS(2);
    }

}
