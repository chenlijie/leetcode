package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenlijie on 7/30/17.
 */
public class BSTIterator {

    private Queue<TreeNode> queue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        inOrderTravesal(root);
    }

    private void inOrderTravesal(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                inOrderTravesal(node.left);
            }
            queue.add(node);

            if (node.right != null) {
                inOrderTravesal(node.right);
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (queue.size() == 0) {
            return false;
        }
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll().val;
    }
}
