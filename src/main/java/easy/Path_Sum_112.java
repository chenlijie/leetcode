package easy;

import medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenlijie on 10/11/17.
 */
public class Path_Sum_112 {

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null && node.val == sum) {
                    return true;
                }

                if (node.left != null) {
                    node.left.val = node.left.val + node.val;
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    node.right.val = node.right.val + node.val;
                    queue.offer(node.right);
                }
            }
        }

        return false;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root != null && root.left == null && root.right == null && sum == root.val) {
            return true;
        }

        if (root == null) {
            return false;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
