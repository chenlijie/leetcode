package facebook.fblist;

import java.util.*;

public class ValidTreeByLinkedNode {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    boolean canContructBinaryTree(Node[] nodes) {
        if (nodes == null || nodes.length == 0)
            return true;

        Set<Node> visited = new HashSet<>();
        int size = 0;

        for (int i = 0; i < nodes.length; i++) {
            visited.clear();
            if (isCyclic(nodes[i], visited)) {
                return false;
            }
            size = Math.max(size, visited.size());
        }


        return nodes.length == visited.size();
    }

    boolean isCyclic(Node node, Set<Node> visited) {
        if (node == null)
            return false;

        if (visited.contains(node))
            return true;

        visited.add(node);
        return isCyclic(node.left, visited) || isCyclic(node.right, visited);
    }

    boolean canContructBinaryTree2(Node[] nodes) {
        Set<Node> children = new HashSet<>();

        for (Node n : nodes) {
            if (n.left != null) {
                if (!children.add(n.left)) {
                    return false;
                }
            }
            if (n.right != null) {
                if (!children.add(n.right)) {
                    return false;
                }
            }
        }

        Node root = null;
        int cnt = 0;

        for (Node n : nodes) {
            if (!children.contains(n)) {
                root = n;
                cnt++;
            }
        }

        if (cnt != 1) return false;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            if (n.left != null) {
                queue.offer(n.left);
                children.remove(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
                children.remove(n.right);
            }
        }

        return children.isEmpty();
    }

    public static void main(String[] args) {
        int len = 4;
        Node[] node = new Node[len];
        for (int i = 0; i < len; i++) {
            node[i] = new Node(i);
        }

        node[0].left = node[1];
        node[0].right = node[2];

        ValidTreeByLinkedNode tree = new ValidTreeByLinkedNode();
        System.out.println(tree.canContructBinaryTree2(node));
    }

}
