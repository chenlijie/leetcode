package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenlijie on 11/16/17.
 */
public class Populating_Next_Right_Pointers_in_Each_Node_II_117 {

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            TreeLinkNode cur = queue.poll();
            addChildren(cur, queue);

            for (int i = 1; i < size; i++) {
                TreeLinkNode next = queue.poll();
                addChildren(next, queue);
                cur.next = next;
                cur = next;
            }
        }
    }

    void addChildren(TreeLinkNode node, Queue<TreeLinkNode> queue) {
        if (node.left != null)
            queue.offer(node.left);

        if (node.right != null)
            queue.offer(node.right);
    }

    public void connect2(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode headOne = null;
        TreeLinkNode headTwo = null;
        TreeLinkNode cur = null;

        headOne = root;

        while (headOne != null) {

            headTwo = new TreeLinkNode(0);
            cur = headTwo;

            while (headOne != null) {
                if (headOne.left != null) {
                    cur.next = headOne.left;
                    cur = cur.next;
                }

                if (headOne.right != null) {
                    cur.next = headOne.right;
                    cur = cur.next;
                }
                headOne = headOne.next;
            }

            headOne = headTwo.next;
        }
    }
}
