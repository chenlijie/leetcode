package graph;

import java.util.ArrayList;
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
        new ToplogicalSorting().sort(new int[][]{
                {4, 0},
                {5, 0},
                {4, 3},
                {3, 0},
                {2, 1},
                {1, 2}
        }, 6);

        int x = (int) (Math.ceil(Math.log(15) / Math.log(2)));

        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;

        System.out.println(x);
        System.out.println(max_size);
    }
}
