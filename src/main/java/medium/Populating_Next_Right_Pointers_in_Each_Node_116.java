package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenlijie on 5/19/17.
 */
public class Populating_Next_Right_Pointers_in_Each_Node_116 {


    public static void connect(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        TreeLinkNode cur;

        while(levelStart != null) {
            cur = levelStart;

            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }

                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
    }


    public static void connect2(TreeLinkNode root) {

        if (root != null) {

            TreeLinkNode node = root;
            Queue<TreeLinkNode> queue = new LinkedList<>();
            queue.add(node);

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeLinkNode node1 = queue.poll();
                    if (i == size-1) {
                        node1.next = null;
                    } else {
                        node1.next = queue.peek();
                    }
                    if (node1.left != null) {
                        queue.add(node1.left);
                    }
                    if (node1.right != null) {
                        queue.add(node1.right);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

        connect(root);

        System.out.println();
    }
}
