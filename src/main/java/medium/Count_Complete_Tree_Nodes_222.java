package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenlijie on 8/11/17.
 */
public class Count_Complete_Tree_Nodes_222 {

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
                count++;
            }

            if (node.right != null) {
                queue.offer(node.right);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(countNodes(root));
    }
}
