package twitch;

import java.util.*;

public class SearchStringInTree {

    static class Node {
        String val;
        List<Node> children;

        public Node(String val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    static boolean search(Node node, String s) {
        if (node == null || s == null)
            return false;

        Queue<Node> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(node);

        while (!q.isEmpty()) {
            Node v = q.peek();


        }
        return false;
    }
}
