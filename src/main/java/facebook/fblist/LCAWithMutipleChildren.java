package facebook.fblist;

import java.util.ArrayList;
import java.util.List;

public class LCAWithMutipleChildren {

    class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "val=" + val;
        }
    }

    Node LCA(Node node) {
        if (node == null)
            return null;

        if (node.children != null && node.children.size() == 1) {
            return LCA(node.children.get(0));
        }

        return node;
    }

    int label = 1;
    void test() {
        Node root = new Node(label++);
        root.children = new ArrayList<>();

        List<Node> list = addChildren(root.children, 2);
        list.get(0).children = new ArrayList<>();
        list = addChildren(list.get(0).children, 2);

        System.out.println(LCA(root).val);
    }

    List<Node> addChildren(List<Node> children, int i) {
        for (int j = 0; j < i; j++) {
            children.add(new Node(label++));
        }
        return children;
    }

    public static void main(String[] args) {
        new LCAWithMutipleChildren().test();
    }
}
