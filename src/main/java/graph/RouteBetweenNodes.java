package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenlijie on 10/17/17.
 */
public class RouteBetweenNodes {

    static class Node {
        boolean visited;
        List<Node> adjacent = new ArrayList<>();
    }

    public static boolean findRoute(Node start, Node end) {
        if (start == end) {
            return true;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node pop = queue.removeFirst();

            if (pop != null) {
                for (Node node : pop.adjacent) {
                    if (!node.visited) {
                        if (node == end) {
                            return true;
                        }
                        queue.add(node);
                    }
                }
            }
            start.visited = true;
        }
        return false;
    }

    public static boolean dfs(Node start, Node end) {
        return dfsHelper(start, end);
    }

    public static boolean dfsHelper(Node start, Node end) {
        if (start == end) {
            return true;
        }

        start.visited = true;

        for (Node node : start.adjacent) {
            if (dfsHelper(node, end)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();

        node1.adjacent.add(node2);
        node1.adjacent.add(node3);

        node3.adjacent.add(node2);
        node3.adjacent.add(node4);

        node4.adjacent.add(node5);
        node4.adjacent.add(node6);
        node4.adjacent.add(node7);

//        System.out.println(findRoute(node1, node7));
        System.out.println(dfs(node1, node2));
    }

}
