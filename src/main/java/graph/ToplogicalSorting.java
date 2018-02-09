package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by chenlijie on 8/31/17.
 */
public class ToplogicalSorting {



    public void sort(int[][] path, int num) {

        boolean[] visited = new boolean[num];
        List<Integer>[] adj = new ArrayList[num];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < path.length; i++) {
            adj[path[i][0]].add(path[i][1]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num; i++) {
            dfs(i, stack, visited, adj);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private void dfs(int s, Stack<Integer> stack, boolean[] visited, List<Integer>[] adj) {

        if (!visited[s]) {

            visited[s] = true;

            for (int i : adj[s]) {
                dfs(i, stack, visited, adj);
            }

            stack.push(s);
        }
    }

    public static void main(String[] args) {
//        new ToplogicalSorting().sort(new int[][]{
//                {0, 2},
//                {1, 2}
//        }, 3);

        topSort(new int[][]{
                {5, 2},
                {5, 0},
                {4, 0},
                {4, 1},
                {2, 3},
                {3, 1},
//                {1, 2}
        }, 6);

    }

    static void topSort(int[][] edges, int n) {
        List<Integer>[] adj = new List[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
        }
        
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                topSortUtil(i, visited, adj, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");
        }
    }

    static void topSortUtil(int i, boolean[] visited, List<Integer>[] adj, Stack<Integer> stack) {
        visited[i] = true;

        for (int u : adj[i]) {
            if (!visited[u]) {
                topSortUtil(u, visited, adj, stack);
            }
        }

        stack.push(i);
    }

    static boolean isCyclic(int i, int[] indgree, int[] status, List[] adj, Stack<Integer> stack) {
        if (status[i] == 1)
            return true;

        status[i] = 1;
        stack.push(i);

        for (int j = 0; j < adj[i].size(); j++) {
            int next = (int)adj[i].get(j);
            indgree[next]--;

            if (indgree[next] == 0 && status[next] == 0) {
                if (isCyclic(next, indgree, status, adj, stack)) {
                    return true;
                }
            } else if (status[next] == 1) {
                return true;
            }
        }

        status[i] = 2;
        return false;
    }

}
