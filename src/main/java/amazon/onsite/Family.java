package amazon.onsite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Family {

    private static class Node {
        int val;
        Node parent;
        List<Node> children = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node parent) {
            this.val = val;
            this.parent = parent;
        }

        public void add(Node ... node) {
            for (Node n : node)
                children.add(n);
        }

        @Override
        public String toString() {
            return val+"";
        }
    }

    static List<Node> find(Node node, int n) {
        Node exclude = null;

        int i = n;
        while (i-- >= 0 && node != null) {
            exclude = node;
            node = node.parent;
        }

        if (i > -1 || node == null) return new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        if (node.children != null) {
            for (Node child : node.children) {
                if (child != exclude)
                    q.offer(child);
            }
        }

        while (n-- > 0 && !q.isEmpty()) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                Node v = q.poll();
                q.addAll(v.children);
            }
        }

        if (n > 0) {
            return new ArrayList<>();
        } else {
            List<Node> list = new ArrayList<>();
            list.addAll(q);
            System.out.println(list);
            return list;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);

        Node n2 = new Node(2, n1);
        Node n3 = new Node(3, n1);

        n1.add(n2, n3);

        Node n4 = new Node(4, n2);
        Node n5 = new Node(5, n2);

        n2.add(n4, n5);

        Node n6 = new Node(6, n3);
        Node n7 = new Node(7, n3);

        n3.add(n6, n7);

        Node n8 = new Node(8, n4);
        Node n9 = new Node(9, n4);

        n4.add(n8, n9);

        Node n10 = new Node(10, n5);
        Node n11 = new Node(11, n5);

        n5.add(n10, n11);

        Node n12 = new Node(12, n6);
        Node n13 = new Node(13, n7);

        n6.add(n12);
        n7.add(n13);

        find(n1, 1);
    }
}
