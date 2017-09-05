package graph;

import java.util.*;

/**
 * Created by chenlijie on 9/1/17.
 */
public class LongestPath {


    static class Edge {
        char src;
        char dest;
        int weight;

        public Edge(char src, char dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {

        Map<Character, List<Edge>> adj;
        Set<Character> nodes;

        public Graph() {
            adj = new HashMap<>();
            nodes = new HashSet<>();

        }

        public void addEdge(char src, char dest, int weight) {
            adj.putIfAbsent(src, new ArrayList<>());
            adj.putIfAbsent(dest, new ArrayList<>());
            adj.get(src).add(new Edge(src, dest, weight));

            nodes.add(src);
            nodes.add(dest);
        }

        private List<Character> topLogicalSorting() {
            Set<Character> visited = new HashSet<>();

            Stack<Character> stack = new Stack<>();

            for (char c : nodes) {
                topLogicalSortHelper(c, visited, stack);
            }

            List<Character> sequence = new ArrayList<>();

            while (!stack.isEmpty()) {
                sequence.add(0, stack.pop());
            }

            return sequence;

        }

        private void topLogicalSortHelper(char s, Set<Character> visited, Stack<Character> stack) {

            if (!visited.contains(s)) {

                visited.add(s);

                for (Edge e : adj.get(s)) {
                    topLogicalSortHelper(e.src, visited, stack);
                }

                stack.push(s);
            }
        }

        public void longestPath(char s) {
            List<Character> sequence = topLogicalSorting();
            Map<Character, Integer> vals = new HashMap<>();

            for (char c : sequence) {
                System.out.print(c + "  ");
                
                if (c == s) {
                    vals.put(c, 0);
                } else {
                    vals.put(c, Integer.MIN_VALUE);
                }
            }
            System.out.println();


            for (char c : sequence) {

                List<Edge> edges = adj.get(c);

                for (Edge e : edges) {
                    char src = e.src;
                    char dest = e.dest;

                    if (vals.get(src) != Integer.MIN_VALUE && vals.get(dest) < vals.get(src)+e.weight) {
                        vals.put(dest, vals.get(src)+e.weight);
                    }
                }
            }

            for (char c : vals.keySet()) {
                if (vals.get(c) != Integer.MIN_VALUE) {
                    System.out.println("The longest path from " + s + " to " + c + " is " + vals.get(c));
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge('r', 's', 5);
        g.addEdge('r', 't', 3);
        g.addEdge('s', 'x', 6);
        g.addEdge('s', 't', 2);
        g.addEdge('t', 'y', 4);
        g.addEdge('t', 'z', 2);
        g.addEdge('t', 'x', 7);
        g.addEdge('x', 'z', 1);
        g.addEdge('x', 'y', -1);
        g.addEdge('y', 'z', -2);

        g.longestPath('s');
    }
}
